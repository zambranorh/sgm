
package om.conecel.claro.lotconector.infraestructure;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


import com.conecel.claro.lotconnector.dto.LotResult;



public class Notify {
	

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	RestTemplate restTemplate;
	
	public Notify(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}

	public void enviaNotificacion(String urlNotify, String recipient, String sender, String lotId, List<LotResult> lote) {
		
	
		try {
			
 			Calendar futherDayC = new GregorianCalendar();
		
            SimpleDateFormat format1 = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss");
            

            String sendDate = format1.format(futherDayC
                    .getTime());

            futherDayC.add(Calendar.YEAR, 1);
            
            String expirationDate = format1.format(futherDayC
                    .getTime());
			
		
			String  subject="Resultado de la regularización del lote # " + lotId.toUpperCase();
			String message="Estimados \\nLuego de la revisión de las órdenes, se confirma las Regularización del lote sin novedad.\\n";   
					
			
			String type="M";
			String notificationClass="SAL";
			String numberRetries="1";
			String timeBetweenRetries="10";
			
			
			String infoAdjunta= dumpDataTab(lote);
			
			//System.out.println("Plantilla: "+ infoAdjunta);
			
			String request="{" +
			"\"notificationInfo\":{" +
		    "\"sendDate\":\""+sendDate+"\"," + 
		    "\"expirationDate\":\""+expirationDate+"\"," + 
		    "\"recipient\":\""+recipient+"\"," + 
		    "\"sender\":\""+sender+"\"," + 
		    "\"subject\":\""+subject+"\"," + 
		    "\"message\":\""+message+infoAdjunta+"\"," + 
		    "\"type\":\""+type+"\"," + 
		    "\"notificationClass\":\""+notificationClass+"\"}," + 
		    "\"retry\":{" +
		    "\"numberRetries\":\""+numberRetries+"\"," +
		    "\"timeBetweenRetries\":\""+timeBetweenRetries+"\"}" +
		    "}"; 

			//http://pojo.sodhanalibrary.com/
			
			
			System.out.println("Request: " + request);
			
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Content-Type", "application/json");

			HttpEntity <String> httpEntity = new HttpEntity <String> (request, httpHeaders);
	
			
			String json = restTemplate.postForObject(urlNotify, httpEntity, String.class);
			
			System.out.println("Json: " + json);
		
			
			

		} catch(Exception e) {
			log.error("Error: ",e);
					
		}
		
	}
	
    public String dumpDataTab(List<LotResult> lote) {

        String html = new String();
        int rowCount = 0;

        try {
            
            html = html + "<div class='contentTabla' >";
            html = html + "<table  id='tabla'  class='tablaDatoTAB'   >";
            
            int columnCount =16;
            int cont=0;
            
            
          
            
            // table header
            
            html = html + "<thead>";
            //html = html + "<tr><th colspan="+columnCount+">"+nombre_indicador+"</th></tr>";
            
            html = html + "<TR>";
          
                html = html + "<TH>" + "No Orden" + "</TH>";
                html = html + "<TH>" + "Cliente" + "</TH>";
                html = html + "<TH>" + "No Identidad" + "</TH>";
                html = html + "<TH>" + "Fecha de activacion" + "</TH>";
                html = html + "<TH>" + "Usuario Ingreso Solicitud" + "</TH>";
                html = html + "<TH>" + "Forma de Pago" + "</TH>";
                html = html + "<TH>" + "Banco" + "</TH>";
                html = html + "<TH>" + "Fecha del reporte" + "</TH>";
                html = html + "<TH>" + "Codigo de oficina" + "</TH>";
                html = html + "<TH>" + "Oficina" + "</TH>";
                html = html + "<TH>" + "Dias" + "</TH>";
                html = html + "<TH>" + "Estado" + "</TH>";
                html = html + "<TH>" + "Motivo" + "</TH>";
                html = html + "<TH>" + "Observacion" + "</TH>";
                html = html + "<TH>" + "Usuario regulariza" + "</TH>";
                html = html + "<TH>" + "Fecha regularizacion" + "</TH>";
                	
           
            html = html + "</TR>";
            html = html + "</thead>";
            html = html + "<tbody>";

            // the data
            while (cont <= lote.size()) {
                rowCount++;
                html = html + "<TR>";
                for (int i = 0; i < columnCount + 1; i++) {

                    try {
                        
                        //String valor = replaceNull(rs.getString(i + 1));
                        
                        for (LotResult lot: lote) {
                        	
                        	html = html + "<TD>" + lot.getOrderId()+ "</TD>";
                        	html = html + "<TD>" + lot.getCustomer() + "</TD>";
                        	html = html + "<TD>" + lot.getIdentidad() + "</TD>";
                        	html = html + "<TD>" + lot.getFechaActivacion() + "</TD>";
                        	html = html + "<TD>" + lot.getUsuarioIngreso() + "</TD>";
                        	html = html + "<TD>" + lot.getFormaPago() + "</TD>";
                        	html = html + "<TD>" + lot.getBanco() + "</TD>";
                        	html = html + "<TD>" + lot.getFechaLote() + "</TD>";
                        	html = html + "<TD>" + lot.getIdOficina() + "</TD>";
                        	html = html + "<TD>" + lot.getOficina() + "</TD>";
                        	html = html + "<TD>" + lot.getDias()+ "</TD>";
                        	html = html + "<TD>" + lot.getEstado() + "</TD>";
                        	html = html + "<TD>" + lot.getMotivo() + "</TD>";
                        	html = html + "<TD>" + lot.getObservacion() + "</TD>";
                        	html = html + "<TD>" + lot.getUsuarioReg() + "</TD>";
                        	html = html + "<TD>" + lot.getFechaReg() + "</TD>";
                        	
           
                			
                		}
                    
                        

                    } catch (Exception ex) {
                    	
                    	ex.printStackTrace();
                    }

                }
                html = html + "</TR>";
            }
            html = html + "</tbody>";

            html = html + "</table></div>";
        } catch (Exception ex) {
        }
        return html;

    }


 
}
