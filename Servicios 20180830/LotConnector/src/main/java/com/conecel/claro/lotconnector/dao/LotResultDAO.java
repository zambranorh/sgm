package com.conecel.claro.lotconnector.dao;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.lotconnector.dto.Audit;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotId;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

@Service
@Transactional
public class LotResultDAO implements ILotResultDAO {

	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo) {

		List<LotResult> resultados;

		Map<String, String> parametros = new HashMap<>();

		String queryGenerated = "select lot.numero_lote, lot.fecha_lote, lot.no_orden, lot.cliente, lot.id_cliente Identidad, lot.fecha_activacion, "
				+ "lot.usuario_ingreso, lot.forma_pago, lot.financiera Banco, "
				+ "lot.id_oficina, lot.oficina, lot.dias, lot.estado, "
				+ "lot.motivo, lot.observacion, lot.usuario_reg, lot.fecha_reg " + "from rc_lotes2 lot where 1=1 ";

		try {

			if (!"".equals(preLotInfo.getLotId())) {
				queryGenerated = queryGenerated + " and upper(numero_lote)= upper(:idLote)";
				parametros.put("idLote", preLotInfo.getLotId());
			}

			if (!"".equals(preLotInfo.getStartDate())) {
				queryGenerated = queryGenerated + " and fecha_activacion>= to_date(:fecha_inicio,'dd/mm/rrrr')";
				parametros.put("fecha_inicio", preLotInfo.getStartDate());
			}

			if (!"".equals(preLotInfo.getEndDate())) {
				queryGenerated = queryGenerated + " and fecha_activacion<= to_date(:fecha_fin,'dd/mm/rrrr')";
				parametros.put("fecha_fin", preLotInfo.getEndDate());
			}

			if (!"".equals(preLotInfo.getOrderId())) {
				queryGenerated = queryGenerated + " and no_orden= :orden";
				parametros.put("orden", preLotInfo.getOrderId());

			}

			if (!"".equals(preLotInfo.getCustomerId())) {
				queryGenerated = queryGenerated + " and id_cliente= :id_cliente";
				parametros.put("id_cliente", preLotInfo.getCustomerId());
			}

			if (!"".equals(preLotInfo.getSalesChannel())) {
				queryGenerated = queryGenerated + " and upper(id_oficina)= upper(:id_oficina)";
				parametros.put("id_oficina", preLotInfo.getSalesChannel());
			}

			if (!"".equals(preLotInfo.getPaymentType())) {
				queryGenerated = queryGenerated + " and forma_pago= :forma_pago";
				parametros.put("forma_pago", preLotInfo.getPaymentType());
			}

			if (!"".equals(preLotInfo.getFinancialInstitution())) {
				queryGenerated = queryGenerated + " and upper(financiera)= upper(:banco)";
				parametros.put("banco", preLotInfo.getFinancialInstitution());
			}
			
			if(!"".equals(preLotInfo.getStatus())) {
				queryGenerated = queryGenerated + " and upper(estado)= upper(:estado)";
				parametros.put("estado", preLotInfo.getStatus());
			}
			
			System.out.println("Query: "+ queryGenerated);
			
			System.out.println("Query: "+ preLotInfo.getStatus());

			TypedQuery<LotResult> query = (TypedQuery<LotResult>) this.getEntityManager()
					.createNativeQuery(queryGenerated, LotResult.class);

			parametros.forEach((k, v) -> query.setParameter(k, v));

			resultados = query.getResultList();
			
			log.info("Lote # " + preLotInfo.getLotId() + "  consultado exitosamente!");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para consulta de lote:", e);
			return null;
		}
		return resultados;
	}

	@Override
	public String creaLote(Lot lote) {

		try {

			List<LotId> ordenes = new ArrayList<>();

			if (!"".equals(lote.getId().getLotId()) && null != lote.getLotDate()) {

				if (!"".equals(lote.getId().getOrderId()) && !"".equals(lote.getProduct())
						&& !"".equals(lote.getCustomer()) && !"".equals(lote.getCustomerId())
						&& null != lote.getActivationDate() && !"".equals(lote.getLoggedUser())
						&& !"".equals(lote.getPaymentType()) && !"".equals(lote.getFinancialInstitution())
						&& !"".equals(lote.getOfficceId()) && !"".equals(lote.getOfficce())
						&& !"".equals(lote.getStatus())) {

					

					lote.setId_seq(lote.getId().getLotId().substring(0, lote.getId().getLotId().indexOf("_", 0)));

					getEntityManager().persist(lote);
					
					log.info("Lote # " + lote.getId().getLotId() + " creado exitosamente!");
					
					registra_auditoria("Lote creado: " + lote.getId().getLotId() + " - Orden: " + lote.getId().getOrderId()  );

					
				} else {
					if (!"".equals(lote.getId())) {
						ordenes.add(lote.getId());

					} else {
						// ordenes.add("Numero de orden es obligatorio!");
					}

				}

			}

			else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para crear lote:", e);
			return null;
		}

		return lote.getId().getLotId();
	}

	@Override
	public boolean actualizaLote(Lot lote) {

		int band = 0;

		try {

			if (!"".equals(lote.getId().getOrderId())) {
				Lot entityActualizar = this.getEntityManager().find(Lot.class, lote.getId());
				
				System.out.println("ID: "+  lote.getId().getLotId());
				System.out.println("Orden: "+  lote.getId().getOrderId());

				if (!"".equals(lote.getStatus())) {

					entityActualizar.setStatus(lote.getStatus());
					band = 1;

				}
				else
				{
					entityActualizar.setStatus("");
					band = 1;
				}
				

				if (!"".equals(lote.getReason())) {
					entityActualizar.setReason(lote.getReason());
					band = 1;
				}
				else
				{
					entityActualizar.setReason("");
					band = 1;
				}
				

				if (!"".equals(lote.getObservation())) {
					entityActualizar.setObservation(lote.getObservation());
					band = 1;
				}
				else
				{
					entityActualizar.setObservation("");
					band = 1;
				}
					
			

				if (!"".equals(lote.getRegularized_user())) {
					entityActualizar.setRegularized_user(lote.getRegularized_user());
					band = 1;
				}
				else
				{
					entityActualizar.setRegularized_user("");
					band = 1;
				}
			
				
				if (null != lote.getRegularizedDate()) {
					entityActualizar.setRegularizedDate(lote.getRegularizedDate());
					band = 1;
				}
				else
				{
					entityActualizar.setRegularizedDate(null);
					band = 1;
				}
			
				

				if (band == 1) {
					
					this.getEntityManager().merge(entityActualizar);
					
				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para actualizar lote:", e);
		}
		
		log.info("Lote # " + lote.getId().getLotId()  + " actualizado exitosamente!");
		
		registra_auditoria("Orden: " + lote.getId().getOrderId() + " - Lote: " + lote.getId().getLotId()
				+ " Estado: " + lote.getStatus());

		return true;
	}

	@Override
	public String obtieneSecuencia() {

		String resultado;

		String queryGenerated = "select nvl(max(id_seq),0)+1 secuencia from rc_lotes2";

		try {

			Query query = (Query) this.getEntityManager().createNativeQuery(queryGenerated);

			BigDecimal secuencia = (BigDecimal) query.getSingleResult();

			resultado = "" + secuencia;
			
			log.info("Secuencia generada:  " + resultado);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en generar la secuencia: ", e);
			return null;
		}

		return resultado;
	}


	public void registra_auditoria(String action) {

		Audit auditInfo = new Audit();
		InetAddress localHost = null;

		try {

			try {
				localHost = InetAddress.getLocalHost();
			} catch (UnknownHostException ue) {
				// TODO Auto-generated catch block
				ue.printStackTrace();
			}

			auditInfo.setSo_user(System.getProperty("user.name"));

			auditInfo.setMachine(localHost.getHostName());
			auditInfo.setIp_address(localHost.getHostAddress());
			auditInfo.setAction(action);

			getEntityManager().persist(auditInfo);
			
			log.info("Auditoría registrada exitosamente: " +  action);
			

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en registrar auditoria para creacion de lote: ", e);
		}

	}

}
