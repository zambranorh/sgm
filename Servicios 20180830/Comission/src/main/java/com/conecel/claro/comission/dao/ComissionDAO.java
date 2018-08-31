package com.conecel.claro.comission.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.conecel.claro.comission.domain.Comission2;

import com.conecel.claro.comission.domain.PreComission2;
import com.conecel.claro.comission.dto.ComissionPeriod;

@Service
@Transactional
public class ComissionDAO implements IComissionDAO {
	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());



	@Override
	public List<PreComission2> generaComision2(ComissionPeriod comissionPeriod) {
		
		HashMap<String,String> parametros = new HashMap<>();
		
		List<PreComission2> resultado = null;
		
		String queryGenerated="select vt.numero_orden,\r\n" + 
				"       o.id_localidad,\r\n" + 
				"       o.id_canal,\r\n" + 
				"       v.nombre NOMBRE_VENDEDOR,\r\n" + 
				"       v.id_vendedor,\r\n" + 
				"       cli.nombre NOMBRE_CLIENTE,\r\n" + 
				"       cli.id_cliente,\r\n" + 
				"       vt.plan,\r\n" + 
				"       vt.id_cuenta,\r\n" + 
				"       vt.fecha_ingreso FECHA_ING,\r\n" + 
				"       lot.fecha_reg,\r\n" + 
				"       lot.usuario_reg,\r\n" + 
				"       vt.equipo,\r\n" + 
				"       vt.cantidad,\r\n" + 
				"       vt.fecha_activacion FECHA_ACT,\r\n" + 
				"       lot.fecha_reg Fecha_Inc,\r\n" + 
				"       lot.usuario_reg Usuario_Inc,\r\n" + 
				"       lot.motivo,\r\n" + 
				"       ((nvl(lot.fecha_reg,sysdate)) - (vt.fecha_activacion)) dias,\r\n" + 
				"       case \r\n" + 
				"         when ((nvl(lot.fecha_reg,sysdate)) - (vt.fecha_activacion)) > 20 then 'NO ENTREGA'\r\n" + 
				"         when ((nvl(lot.fecha_reg,sysdate)) - (vt.fecha_activacion)) < 5  then 'ENTREGA A TIEMPO'\r\n" + 
				"          else 'FUERA DE TIEMPO'\r\n" + 
				"       end  Mensaje   \r\n" + 
				"  from rc_venta vt\r\n" + 
				"  left join rc_lotes2 lot\r\n" + 
				"    on vt.numero_orden = lot.no_orden, rc_vendedor v, rc_oficinas o,\r\n" + 
				" rc_cliente cli\r\n" + 
				" where vt.id_vendedor = v.id_vendedor\r\n" + 
				"   and vt.id_oficina = o.id_oficina\r\n" + 
				"   and vt.id_cliente = cli.id_cliente\r\n" + 
				"   and vt.numero_orden not in (select c.id_solicitud  from rc_comisiones2 c)";

		
		
		try {
			/*TypedQuery<PreComission2> query = this.getEntityManager().createNamedQuery("PreComission2.generaComision2",
					PreComission2.class);*/

			if (!"".equals(comissionPeriod.getStartDate())
					|| !comissionPeriod.getStartDate().isEmpty() && !"".equals(comissionPeriod.getEndDate())
					|| !comissionPeriod.getEndDate().isEmpty()) {
				//query.setParameter(1, comissionPeriod.getStartDate());
				//query.setParameter(2, comissionPeriod.getEndDate());
				queryGenerated= queryGenerated + " and vt.fecha_ingreso>= to_date(:fecha_inicio,'dd/mm/yyyy')";
				parametros.put("fecha_inicio", comissionPeriod.getStartDate());
				queryGenerated= queryGenerated + " and vt.fecha_ingreso<= to_date(:fecha_fin,'dd/mm/yyyy')";
				parametros.put("fecha_fin", comissionPeriod.getEndDate());
				
				System.out.println("Frcha inicio: " + comissionPeriod.getStartDate());
				System.out.println("Frcha fin: " + comissionPeriod.getEndDate());
				
			} else {

				int dia, mes, anio;

				dia = Calendar.DATE;
				mes = Calendar.MONTH;
				anio = Calendar.YEAR;

				String fecha = dia + "/" + mes + "/" + anio;

				//query.setParameter(1, fecha);
				//query.setParameter(2, fecha);
				
				parametros.put("fecha_inicio", fecha);
				parametros.put("fecha_fin", fecha);

			}
			
			TypedQuery<PreComission2> query = (TypedQuery<PreComission2>) this.getEntityManager().createNativeQuery(queryGenerated,PreComission2.class);

			parametros.forEach((k,v)-> query.setParameter(k, v));
			
			resultado = query.getResultList();

			log.info("Comision recuperada exitosamente!");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para calcular comisiones: ", e);
			return resultado;
		}

		return resultado;
	}

	@Override
	public String insertaComision2(Comission2 comission) {
		try {

			getEntityManager().persist(comission);

			log.info("Comision generada exitosamente!");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para generar comisiones: ", e);
			return null;
		}

		return "OK";
	}

}
