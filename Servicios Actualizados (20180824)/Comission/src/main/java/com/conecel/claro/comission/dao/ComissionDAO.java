package com.conecel.claro.comission.dao;

import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.Comission2;
import com.conecel.claro.comission.domain.PreComission;
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
	public List<PreComission> generaComision(ComissionPeriod comissionPeriod) {

		List<PreComission> resultado = null;

		try {
			TypedQuery<PreComission> query = this.getEntityManager().createNamedQuery("PreComission.generaComision",
					PreComission.class);

			if (!"".equals(comissionPeriod.getStartDate())
					|| !comissionPeriod.getStartDate().isEmpty() && !"".equals(comissionPeriod.getEndDate())
					|| !comissionPeriod.getEndDate().isEmpty()) {
				query.setParameter(1, comissionPeriod.getStartDate());
				query.setParameter(2, comissionPeriod.getEndDate());
			} else {

				int dia, mes, anio;

				dia = Calendar.DATE;
				mes = Calendar.MONTH;
				anio = Calendar.YEAR;

				String fecha = dia + "/" + mes + "/" + anio;

				query.setParameter(1, fecha);
				query.setParameter(2, fecha);

			}

			resultado = query.getResultList();

			log.info("Comision recuperada exitosamnte!");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para calcular comisiones: ", e);
			return resultado;
		}

		return resultado;
	}

	@Override
	public String insertaComision(Comission comission) {

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

	@Override
	public List<PreComission2> generaComision2(ComissionPeriod comissionPeriod) {
		
		List<PreComission2> resultado = null;

		try {
			TypedQuery<PreComission2> query = this.getEntityManager().createNamedQuery("PreComission2.generaComision2",
					PreComission2.class);

			if (!"".equals(comissionPeriod.getStartDate())
					|| !comissionPeriod.getStartDate().isEmpty() && !"".equals(comissionPeriod.getEndDate())
					|| !comissionPeriod.getEndDate().isEmpty()) {
				query.setParameter(1, comissionPeriod.getStartDate());
				query.setParameter(2, comissionPeriod.getEndDate());
			} else {

				int dia, mes, anio;

				dia = Calendar.DATE;
				mes = Calendar.MONTH;
				anio = Calendar.YEAR;

				String fecha = dia + "/" + mes + "/" + anio;

				query.setParameter(1, fecha);
				query.setParameter(2, fecha);

			}

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
