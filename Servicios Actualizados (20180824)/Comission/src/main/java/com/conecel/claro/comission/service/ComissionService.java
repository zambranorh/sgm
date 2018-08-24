package com.conecel.claro.comission.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.Comission2;
import com.conecel.claro.comission.domain.ComissionResult;
import com.conecel.claro.comission.domain.ComissionRules;
import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.domain.PreComission2;
import com.conecel.claro.comission.dto.ComissionInputs;
import com.conecel.claro.comission.dto.ComissionInputs2;
import com.conecel.claro.comission.dto.ComissionPeriod;
import com.conecel.claro.comission.infraestructure.MicroEIS;
import com.conecel.claro.comission.util.ComissionResponse;
import com.conecel.claro.comission.util.ComissionResponse2;
import com.conecel.claro.comission.util.GeneratedComissionResponse;

@Service
public class ComissionService implements IComissionService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ComissionInfoService comissionInfoService;

	@Autowired
	IComissionRulesService comissionRules;

	@Autowired
	IComissionCreationService comissionCreation;

	@Autowired
	IPreComissionService preComissionService;

	@Autowired
	IComissionResultService comissionResultService;

	ComissionResponse comissionResponse;

	ComissionResponse2 comissionResponse2;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public GeneratedComissionResponse generaComision(ComissionPeriod comissionPeriod) {

		List<PreComission> preComissions = new ArrayList<>();
		GeneratedComissionResponse response = new GeneratedComissionResponse();
		List<ComissionRules> reglas = null;
		MicroEIS microEis = new MicroEIS(restTemplate);
		Comission comission;

		String localidad = "GYE";

		try {

			preComissions = preComissionService.generaComision(comissionPeriod);

			for (PreComission preComision : preComissions) {

				String comision = microEis.obtieneComision(comissionInfoService.getUrlMEis(), preComision.getIdOrder(),
						preComision.getAccount(), comissionInfoService.getInformationService(),
						comissionInfoService.getDataSource());
				System.out.println("Resultado jeis: " + comision);

				if (!preComision.getLocationId().equals("GYE")) {
					localidad = "ND";
				}

				reglas = comissionRules.obtieneComisionPorOrdenYCuenta(preComision.getChannel(), localidad);

				for (ComissionRules regla : reglas) {

					if ((preComision.getDeliveryDays() >= regla.getStartDay())
							&& (preComision.getDeliveryDays() <= regla.getEndDay())) {

						comission = new Comission();

						float penalizacion = regla.getValue();

						float subComision = new Integer(comision);

						float multa = (subComision * penalizacion) / 100;

						float totalComision = subComision - multa;

						comission.setIdOrder(preComision.getIdOrder());
						comission.setAccount(preComision.getAccount());
						comission.setSellerId(preComision.getSellerId());
						comission.setSellerName(preComision.getSellerName());
						comission.setChannel(preComision.getChannel());
						comission.setLocationId(preComision.getLocationId());
						comission.setDeliveryDays(preComision.getDeliveryDays());
						comission.setSubComission(subComision);
						comission.setPenaltyValue(penalizacion);
						comission.setComissionValue(totalComision);

						comissionCreation.insertaComisiones(comission);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en servicio al generar comision. ", e);
		}

		response.setCode("0");
		response.setMessage("OK");

		return response;
	}

	@Override
	public ComissionResponse getComissions(ComissionInputs comissionInputs) {

		comissionResponse = new ComissionResponse();

		try {

			List<Comission> comisiones = comissionResultService.obtieneComisiones(comissionInputs);
			comissionResponse.setComission(comisiones);

			if (comisiones == null) {
				comissionResponse.setCode("-1");
				comissionResponse.setMessage("Not Ok!");
				return comissionResponse;
			}

			comissionResponse.setCode("0");
			comissionResponse.setMessage("OK");

		} catch (Exception e) {
			e.printStackTrace();
			comissionResponse.setCode("-1");
			comissionResponse.setMessage("Not Ok!");
			log.error("Error en servicio para obtener comisiones: ", e);
		}
		return comissionResponse;
	}

	@Override
	public ComissionResponse2 getComissions2(ComissionInputs2 comissionInputs) {

		comissionResponse2 = new ComissionResponse2();

		try {

			List<ComissionResult> comisiones = comissionResultService.obtieneComisiones2(comissionInputs);
			comissionResponse2.setComission(comisiones);
			

			if (comisiones == null) {
				comissionResponse2.setCode("-1");
				comissionResponse2.setMessage("Not Ok!");
				return comissionResponse2;
			}

			comissionResponse2.setCode("0");
			comissionResponse2.setMessage("OK");
			comissionResponse2.setRecords(comisiones.size());

		} catch (Exception e) {
			e.printStackTrace();
			comissionResponse2.setCode("-1");
			comissionResponse2.setMessage("Not Ok!");
			log.error("Error en servicio para obtener comisiones: ", e);
		}
		return comissionResponse2;
	}

	@Override
	public GeneratedComissionResponse generaComision2(ComissionPeriod comissionPeriod) {
		List<PreComission2> preComissions = new ArrayList<>();
		GeneratedComissionResponse response = new GeneratedComissionResponse();
		List<ComissionRules> reglas = null;
		MicroEIS microEis = new MicroEIS(restTemplate);
		Comission2 comission;

		String localidad = "GYE";

		try {

			preComissions = preComissionService.generaComision2(comissionPeriod);
			
		
			

			for (PreComission2 preComision : preComissions) {

				String comision = microEis.obtieneComision(comissionInfoService.getUrlMEis(), preComision.getIdOrder(),
						preComision.getAccount(), comissionInfoService.getInformationService(),
						comissionInfoService.getDataSource());
				
				System.out.println("Resultado jeis: " + comision);

				if (!preComision.getLocationId().equals("GYE")) {
					localidad = "ND";
				}

				reglas = comissionRules.obtieneComisionPorOrdenYCuenta(preComision.getChannel(), localidad);

				
				for (ComissionRules regla : reglas) {

					
					if ((preComision.getDeliveryDays() >= regla.getStartDay())
							&& (preComision.getDeliveryDays() <= regla.getEndDay())) {

						comission = new Comission2();

						float penalizacion = regla.getValue();

						float subComision = new Integer(comision);

						float multa = (subComision * penalizacion) / 100;

						float totalComision = subComision - multa;
						
						System.out.println(" subComision" + subComision);
						System.out.println(" penalizacion" + penalizacion);
						System.out.println(" totalComision" + totalComision);

						comission.setIdOrder(preComision.getIdOrder());
						comission.setLocationId(preComision.getLocationId());
						comission.setChannel(preComision.getChannel());
						comission.setSellerName(preComision.getSellerName());
						comission.setSellerId(preComision.getSellerId());
						comission.setCustomerName(preComision.getCustomerName());
						comission.setCustomerId(preComision.getCustomerId());
						comission.setPlan(preComision.getPlan());
						comission.setAccount(preComision.getAccount());
						comission.setRegisterDate(preComision.getRegisterDate());
						comission.setRegularizationDate(preComision.getRegularizationDate());
						comission.setRegularizationUser(preComision.getRegularizationUser());
						comission.setDevice(preComision.getDevice());
						comission.setQuantity(preComision.getQuantity());
						comission.setActivationDate(preComision.getActivationDate());
						comission.setInconsistencyDate(preComision.getInconsistencyDate());
						comission.setInconsistencyUser(preComision.getInconsistencyUser());
						comission.setInconsistency(preComision.getInconsistency());
						comission.setDeliveryDays(preComision.getDeliveryDays());
						comission.setSubComission(subComision);
						comission.setPenaltyValue(penalizacion);
						comission.setComissionValue(totalComision);
						comission.setMessage(preComision.getMessage());

						comissionCreation.insertaComisiones2 (comission);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en servicio al generar comision. ", e);
		}

		response.setCode("0");
		response.setMessage("OK");

		return response;
	}

}
