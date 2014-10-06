
package com.webservicesodispol;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservicesodispol package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DatosProfesionalCedula_QNAME = new QName("http://WebServiceSodispol.com/", "datosProfesionalCedula");
    private final static QName _DatosEstudianteCedula_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteCedula");
    private final static QName _DatosEstudianteCedulaResponse_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteCedulaResponse");
    private final static QName _DatosEstudianteMatriculaResponse_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteMatriculaResponse");
    private final static QName _TipoUsuario_QNAME = new QName("http://WebServiceSodispol.com/", "tipoUsuario");
    private final static QName _TipoUsuarioResponse_QNAME = new QName("http://WebServiceSodispol.com/", "tipoUsuarioResponse");
    private final static QName _DatosEstudianteMatricula_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteMatricula");
    private final static QName _DatosEstudianteUsernameResponse_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteUsernameResponse");
    private final static QName _DatosEstudianteUsername_QNAME = new QName("http://WebServiceSodispol.com/", "datosEstudianteUsername");
    private final static QName _DatosProfesionalUsername_QNAME = new QName("http://WebServiceSodispol.com/", "datosProfesionalUsername");
    private final static QName _DatosProfesionalUsernameResponse_QNAME = new QName("http://WebServiceSodispol.com/", "datosProfesionalUsernameResponse");
    private final static QName _DatosProfesionalCedulaResponse_QNAME = new QName("http://WebServiceSodispol.com/", "datosProfesionalCedulaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservicesodispol
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosEstudianteCedula }
     * 
     */
    public DatosEstudianteCedula createDatosEstudianteCedula() {
        return new DatosEstudianteCedula();
    }

    /**
     * Create an instance of {@link DatosEstudianteCedulaResponse }
     * 
     */
    public DatosEstudianteCedulaResponse createDatosEstudianteCedulaResponse() {
        return new DatosEstudianteCedulaResponse();
    }

    /**
     * Create an instance of {@link DatosProfesionalUsernameResponse }
     * 
     */
    public DatosProfesionalUsernameResponse createDatosProfesionalUsernameResponse() {
        return new DatosProfesionalUsernameResponse();
    }

    /**
     * Create an instance of {@link TipoUsuarioResponse }
     * 
     */
    public TipoUsuarioResponse createTipoUsuarioResponse() {
        return new TipoUsuarioResponse();
    }

    /**
     * Create an instance of {@link DatosProfesionalUsername }
     * 
     */
    public DatosProfesionalUsername createDatosProfesionalUsername() {
        return new DatosProfesionalUsername();
    }

    /**
     * Create an instance of {@link DatosProfesionalCedula }
     * 
     */
    public DatosProfesionalCedula createDatosProfesionalCedula() {
        return new DatosProfesionalCedula();
    }

    /**
     * Create an instance of {@link DatosEstudianteMatriculaResponse }
     * 
     */
    public DatosEstudianteMatriculaResponse createDatosEstudianteMatriculaResponse() {
        return new DatosEstudianteMatriculaResponse();
    }

    /**
     * Create an instance of {@link DatosEstudianteUsernameResponse }
     * 
     */
    public DatosEstudianteUsernameResponse createDatosEstudianteUsernameResponse() {
        return new DatosEstudianteUsernameResponse();
    }

    /**
     * Create an instance of {@link DatosEstudianteUsername }
     * 
     */
    public DatosEstudianteUsername createDatosEstudianteUsername() {
        return new DatosEstudianteUsername();
    }

    /**
     * Create an instance of {@link DatosProfesionalCedulaResponse }
     * 
     */
    public DatosProfesionalCedulaResponse createDatosProfesionalCedulaResponse() {
        return new DatosProfesionalCedulaResponse();
    }

    /**
     * Create an instance of {@link DatosEstudianteMatricula }
     * 
     */
    public DatosEstudianteMatricula createDatosEstudianteMatricula() {
        return new DatosEstudianteMatricula();
    }

    /**
     * Create an instance of {@link TipoUsuario }
     * 
     */
    public TipoUsuario createTipoUsuario() {
        return new TipoUsuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProfesionalCedula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosProfesionalCedula")
    public JAXBElement<DatosProfesionalCedula> createDatosProfesionalCedula(DatosProfesionalCedula value) {
        return new JAXBElement<DatosProfesionalCedula>(_DatosProfesionalCedula_QNAME, DatosProfesionalCedula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteCedula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteCedula")
    public JAXBElement<DatosEstudianteCedula> createDatosEstudianteCedula(DatosEstudianteCedula value) {
        return new JAXBElement<DatosEstudianteCedula>(_DatosEstudianteCedula_QNAME, DatosEstudianteCedula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteCedulaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteCedulaResponse")
    public JAXBElement<DatosEstudianteCedulaResponse> createDatosEstudianteCedulaResponse(DatosEstudianteCedulaResponse value) {
        return new JAXBElement<DatosEstudianteCedulaResponse>(_DatosEstudianteCedulaResponse_QNAME, DatosEstudianteCedulaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteMatriculaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteMatriculaResponse")
    public JAXBElement<DatosEstudianteMatriculaResponse> createDatosEstudianteMatriculaResponse(DatosEstudianteMatriculaResponse value) {
        return new JAXBElement<DatosEstudianteMatriculaResponse>(_DatosEstudianteMatriculaResponse_QNAME, DatosEstudianteMatriculaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "tipoUsuario")
    public JAXBElement<TipoUsuario> createTipoUsuario(TipoUsuario value) {
        return new JAXBElement<TipoUsuario>(_TipoUsuario_QNAME, TipoUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "tipoUsuarioResponse")
    public JAXBElement<TipoUsuarioResponse> createTipoUsuarioResponse(TipoUsuarioResponse value) {
        return new JAXBElement<TipoUsuarioResponse>(_TipoUsuarioResponse_QNAME, TipoUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteMatricula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteMatricula")
    public JAXBElement<DatosEstudianteMatricula> createDatosEstudianteMatricula(DatosEstudianteMatricula value) {
        return new JAXBElement<DatosEstudianteMatricula>(_DatosEstudianteMatricula_QNAME, DatosEstudianteMatricula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteUsernameResponse")
    public JAXBElement<DatosEstudianteUsernameResponse> createDatosEstudianteUsernameResponse(DatosEstudianteUsernameResponse value) {
        return new JAXBElement<DatosEstudianteUsernameResponse>(_DatosEstudianteUsernameResponse_QNAME, DatosEstudianteUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosEstudianteUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosEstudianteUsername")
    public JAXBElement<DatosEstudianteUsername> createDatosEstudianteUsername(DatosEstudianteUsername value) {
        return new JAXBElement<DatosEstudianteUsername>(_DatosEstudianteUsername_QNAME, DatosEstudianteUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProfesionalUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosProfesionalUsername")
    public JAXBElement<DatosProfesionalUsername> createDatosProfesionalUsername(DatosProfesionalUsername value) {
        return new JAXBElement<DatosProfesionalUsername>(_DatosProfesionalUsername_QNAME, DatosProfesionalUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProfesionalUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosProfesionalUsernameResponse")
    public JAXBElement<DatosProfesionalUsernameResponse> createDatosProfesionalUsernameResponse(DatosProfesionalUsernameResponse value) {
        return new JAXBElement<DatosProfesionalUsernameResponse>(_DatosProfesionalUsernameResponse_QNAME, DatosProfesionalUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProfesionalCedulaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServiceSodispol.com/", name = "datosProfesionalCedulaResponse")
    public JAXBElement<DatosProfesionalCedulaResponse> createDatosProfesionalCedulaResponse(DatosProfesionalCedulaResponse value) {
        return new JAXBElement<DatosProfesionalCedulaResponse>(_DatosProfesionalCedulaResponse_QNAME, DatosProfesionalCedulaResponse.class, null, value);
    }

}
