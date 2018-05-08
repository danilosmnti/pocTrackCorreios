//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.05.08 às 07:52:36 AM BRT 
//


package com.poc.services.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sobreWebServiceResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="sobreWebServiceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sobreWebService" type="{http://service.logisticareversa.correios.com.br/}retornoSobreWebService" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sobreWebServiceResponse", propOrder = {
    "sobreWebService"
})
public class SobreWebServiceResponse {

    protected RetornoSobreWebService sobreWebService;

    /**
     * Obtém o valor da propriedade sobreWebService.
     * 
     * @return
     *     possible object is
     *     {@link RetornoSobreWebService }
     *     
     */
    public RetornoSobreWebService getSobreWebService() {
        return sobreWebService;
    }

    /**
     * Define o valor da propriedade sobreWebService.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoSobreWebService }
     *     
     */
    public void setSobreWebService(RetornoSobreWebService value) {
        this.sobreWebService = value;
    }

}
