//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.07 at 01:32:09 PM BRT 
//


package com.poc.services.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitarPostagemSimultaneaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitarPostagemSimultaneaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="solicitarPostagemSimultanea" type="{http://service.logisticareversa.correios.com.br/}retornoPostagem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitarPostagemSimultaneaResponse", propOrder = {
    "solicitarPostagemSimultanea"
})
public class SolicitarPostagemSimultaneaResponse {

    protected RetornoPostagem solicitarPostagemSimultanea;

    /**
     * Gets the value of the solicitarPostagemSimultanea property.
     * 
     * @return
     *     possible object is
     *     {@link RetornoPostagem }
     *     
     */
    public RetornoPostagem getSolicitarPostagemSimultanea() {
        return solicitarPostagemSimultanea;
    }

    /**
     * Sets the value of the solicitarPostagemSimultanea property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoPostagem }
     *     
     */
    public void setSolicitarPostagemSimultanea(RetornoPostagem value) {
        this.solicitarPostagemSimultanea = value;
    }

}