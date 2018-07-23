package com.conecel.claro.comissionconector.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.conecel.claro.comissionconector.dto.PreComissionInfo;
import com.conecel.claro.comissionconector.infraestructure.MicroEIS;
import com.conecel.claro.comissionconector.util.ComissionResponse;
import com.conecel.claro.comissionconector.util.PreComissionResponse;
import com.conecel.claro.comissionconnector.domain.ComissionResult;

@Service
public class PreComissionService {

	PreComissionResponse preComissionResponse;
	
	@Autowired
	ComissionInfoService comissionInfoService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	IComissionResultService  comissionResultService;
	

	private Long comissionAmount;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public PreComissionResponse comissionValue(PreComissionInfo preComissionInfo) {
		
		
		MicroEIS microEis = new MicroEIS(restTemplate);
		
		preComissionResponse = new PreComissionResponse();
		
		String comissionResult = microEis.obtieneComision(comissionInfoService.getUrlMEis(), preComissionInfo.getRequestId(), preComissionInfo.getAccountId(), comissionInfoService.getInformationService(), comissionInfoService.getDataSource());
		
	
				
		
		
		
		ComissionResult comissionResult2 = comissionResultService.obtieneComisionPorSolicitudYCuenta(preComissionInfo.getRequestId(), preComissionInfo.getAccountId());
		
		if (comissionResult == null || comissionResult2 ==null) {
			
			preComissionResponse.setCode("-1");
			preComissionResponse.setMessage("Error Con el Microeis");
			preComissionResponse.setResult(null);
			
			return preComissionResponse;
		}
		
		
		
		
		
		Long comission = new Long(comissionResult);
		

		preComissionResponse = new PreComissionResponse();

		boolean comparaRango = new Long(preComissionInfo.getDeliveryDays()) < new Long(comissionInfoService.getPlazo_maximo());

		boolean verificaPeriodoCAC = (new Long(preComissionInfo.getDeliveryDays()) > comissionInfoService.getPlazo_cac_gye()
				&& comparaRango);
		boolean verificaPeriodoDA = (new Long(preComissionInfo.getDeliveryDays()) > comissionInfoService.getPlazo_da_gye()
				&& comparaRango);

		try {
			comissionAmount = comission;

			if ("CAC".equals(preComissionInfo.getChannelId()) && ("GYE".equals(preComissionInfo.getLocationId()))
					&& verificaPeriodoCAC) {

				comissionAmount = comission - (comission * comissionInfoService.getMulta_cac_ft() / 100);

			} else {
				if (new Long(preComissionInfo.getDeliveryDays()) > comissionInfoService.getPlazo_maximo()) {
					comissionAmount = comission - (comission * comissionInfoService.getMulta_cac_ne() / 100);

				} else {
					if ("DA".equals(preComissionInfo.getChannelId()) && "GYE".equals(preComissionInfo.getLocationId())
							&& verificaPeriodoDA) {

						comissionAmount = comission - (comission * comissionInfoService.getMulta_da_ft() / 100);
					} else {
						if (new Long(preComissionInfo.getDeliveryDays()) > comissionInfoService.getPlazo_maximo()) {
							comissionAmount = comission - (comission * comissionInfoService.getMulta_da_ne() / 100);

						}

					}
				}
			}
			
			

			preComissionResponse.setCode("0");
			preComissionResponse.setMessage("OK");
			
			
			ComissionResponse comissionResponse = new ComissionResponse() ;
			comissionResponse.setNombre(comissionResult2.getNombre());
			comissionResponse.setCanal(comissionResult2.getIdCanal());
			comissionResponse.setLocalidad(comissionResult2.getIdLocalidad());
			comissionResponse.setComision(comissionAmount+"" );
			preComissionResponse.setResult(comissionResponse);

		} catch (Exception e) {
			preComissionResponse.setCode("-1");
			preComissionResponse.setMessage("Error: " + e.getMessage());
			preComissionResponse.setResult(null);

			log.error("Hubo error", e);

		}

		return preComissionResponse;

	}

}
