package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaPaquete extends javax.swing.JInternalFrame {

    public VistaPaquete() {
        initComponents();
    }

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public void setBtncancelar(JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    public JButton getBtncrear() {
        return btncrear;
    }

    public void setBtncrear(JButton btncrear) {
        this.btncrear = btncrear;
    }

    public JButton getBtneliminar() {
        return btneliminar;
    }

    public void setBtneliminar(JButton btneliminar) {
        this.btneliminar = btneliminar;
    }

    public JButton getBtnguardar() {
        return btnguardar;
    }

    public void setBtnguardar(JButton btnguardar) {
        this.btnguardar = btnguardar;
    }

    public JButton getBtnmodificar() {
        return btnmodificar;
    }

    public void setBtnmodificar(JButton btnmodificar) {
        this.btnmodificar = btnmodificar;
    }

    public JTextField getTxtnombreprovincia() {
        return txtnombreprovincia;
    }

    public void setTxtnombreprovincia(JTextField txtnombreprovincia) {
        this.txtnombreprovincia = txtnombreprovincia;
    }

    public JDialog getjDlgCamionero() {
        return jDlgCamionero;
    }

    public void setjDlgCamionero(JDialog jDlgCamionero) {
        this.jDlgCamionero = jDlgCamionero;
    }

    public JDialog getjDlgClientes() {
        return jDlgClientes;
    }

    public void setjDlgClientes(JDialog jDlgClientes) {
        this.jDlgClientes = jDlgClientes;
    }

    public JDialog getjDlgDestinatario() {
        return jDlgDestinatario;
    }

    public void setjDlgDestinatario(JDialog jDlgDestinatario) {
        this.jDlgDestinatario = jDlgDestinatario;
    }

    public JDialog getjDlgPaquetes() {
        return jDlgPaquetes;
    }

    public void setjDlgPaquetes(JDialog jDlgPaquetes) {
        this.jDlgPaquetes = jDlgPaquetes;
    }

    public JInternalFrame getjInternalFrame1() {
        return jInternalFrame1;
    }

    public void setjInternalFrame1(JInternalFrame jInternalFrame1) {
        this.jInternalFrame1 = jInternalFrame1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JDateChooser getJclfecharegistro() {
        return jclfecharegistro;
    }

    public void setJclfecharegistro(JDateChooser jclfecharegistro) {
        this.jclfecharegistro = jclfecharegistro;
    }

    public JDateChooser getJclllegadapro() {
        return jclllegadapro;
    }

    public void setJclllegadapro(JDateChooser jclllegadapro) {
        this.jclllegadapro = jclllegadapro;
    }

    public JDateChooser getJclsalidapro() {
        return jclsalidapro;
    }

    public void setJclsalidapro(JDateChooser jclsalidapro) {
        this.jclsalidapro = jclsalidapro;
    }

    public JLabel getLbcedcamionero() {
        return lbcedcamionero;
    }

    public void setLbcedcamionero(JLabel lbcedcamionero) {
        this.lbcedcamionero = lbcedcamionero;
    }

    public JLabel getLblcedcliente() {
        return lblcedcliente;
    }

    public void setLblcedcliente(JLabel lblcedcliente) {
        this.lblcedcliente = lblcedcliente;
    }

    public JLabel getLblceddestinatario() {
        return lblceddestinatario;
    }

    public void setLblceddestinatario(JLabel lblceddestinatario) {
        this.lblceddestinatario = lblceddestinatario;
    }

    public JLabel getLblcliente() {
        return lblcliente;
    }

    public void setLblcliente(JLabel lblcliente) {
        this.lblcliente = lblcliente;
    }

    public JLabel getLblcodcamionero() {
        return lblcodcamionero;
    }

    public void setLblcodcamionero(JLabel lblcodcamionero) {
        this.lblcodcamionero = lblcodcamionero;
    }

    public JLabel getLblcodcliente() {
        return lblcodcliente;
    }

    public void setLblcodcliente(JLabel lblcodcliente) {
        this.lblcodcliente = lblcodcliente;
    }

    public JLabel getLblcoddestinatario() {
        return lblcoddestinatario;
    }

    public void setLblcoddestinatario(JLabel lblcoddestinatario) {
        this.lblcoddestinatario = lblcoddestinatario;
    }

    public JLabel getLblcodprovincia() {
        return lblcodprovincia;
    }

    public void setLblcodprovincia(JLabel lblcodprovincia) {
        this.lblcodprovincia = lblcodprovincia;
    }

    public JLabel getLbldestinatario() {
        return lbldestinatario;
    }

    public void setLbldestinatario(JLabel lbldestinatario) {
        this.lbldestinatario = lbldestinatario;
    }

    public JLabel getLblfecharegistro() {
        return lblfecharegistro;
    }

    public void setLblfecharegistro(JLabel lblfecharegistro) {
        this.lblfecharegistro = lblfecharegistro;
    }

    public JLabel getLblllegadapro() {
        return lblllegadapro;
    }

    public void setLblllegadapro(JLabel lblllegadapro) {
        this.lblllegadapro = lblllegadapro;
    }

    public JLabel getLblnomcamionero() {
        return lblnomcamionero;
    }

    public void setLblnomcamionero(JLabel lblnomcamionero) {
        this.lblnomcamionero = lblnomcamionero;
    }

    public JLabel getLblpeso() {
        return lblpeso;
    }

    public void setLblpeso(JLabel lblpeso) {
        this.lblpeso = lblpeso;
    }

    public JLabel getLblprovincia() {
        return lblprovincia;
    }

    public void setLblprovincia(JLabel lblprovincia) {
        this.lblprovincia = lblprovincia;
    }

    public JLabel getLblsalidapro() {
        return lblsalidapro;
    }

    public void setLblsalidapro(JLabel lblsalidapro) {
        this.lblsalidapro = lblsalidapro;
    }

    public JLabel getLbltitulo() {
        return lbltitulo;
    }

    public void setLbltitulo(JLabel lbltitulo) {
        this.lbltitulo = lbltitulo;
    }

    public JLabel getLbltitulo1() {
        return lbltitulo1;
    }

    public void setLbltitulo1(JLabel lbltitulo1) {
        this.lbltitulo1 = lbltitulo1;
    }

    public JLabel getLbltitulo2() {
        return lbltitulo2;
    }

    public void setLbltitulo2(JLabel lbltitulo2) {
        this.lbltitulo2 = lbltitulo2;
    }

    public JPanel getPblprincipaldes() {
        return pblprincipaldes;
    }

    public void setPblprincipaldes(JPanel pblprincipaldes) {
        this.pblprincipaldes = pblprincipaldes;
    }

    public JPanel getPnlprincipal() {
        return pnlprincipal;
    }

    public void setPnlprincipal(JPanel pnlprincipal) {
        this.pnlprincipal = pnlprincipal;
    }

    public JPanel getPnlprincipalcam() {
        return pnlprincipalcam;
    }

    public void setPnlprincipalcam(JPanel pnlprincipalcam) {
        this.pnlprincipalcam = pnlprincipalcam;
    }

    public JPanel getPnlprincipalcli() {
        return pnlprincipalcli;
    }

    public void setPnlprincipalcli(JPanel pnlprincipalcli) {
        this.pnlprincipalcli = pnlprincipalcli;
    }

    public JPanel getPnlprincipalframe() {
        return pnlprincipalframe;
    }

    public void setPnlprincipalframe(JPanel pnlprincipalframe) {
        this.pnlprincipalframe = pnlprincipalframe;
    }

    public JTable getTablapaquetes() {
        return tablapaquetes;
    }

    public void setTablapaquetes(JTable tablapaquetes) {
        this.tablapaquetes = tablapaquetes;
    }

    public JTable getTblcamioneros() {
        return tblcamioneros;
    }

    public void setTblcamioneros(JTable tblcamioneros) {
        this.tblcamioneros = tblcamioneros;
    }

    public JTable getTblclientes() {
        return tblclientes;
    }

    public void setTblclientes(JTable tblclientes) {
        this.tblclientes = tblclientes;
    }

    public JTable getTbldestinatarios() {
        return tbldestinatarios;
    }

    public void setTbldestinatarios(JTable tbldestinatarios) {
        this.tbldestinatarios = tbldestinatarios;
    }

    public JTextField getTxtbuscar() {
        return txtbuscar;
    }

    public void setTxtbuscar(JTextField txtbuscar) {
        this.txtbuscar = txtbuscar;
    }

    public JTextField getTxtcedcamionero() {
        return txtcedcamionero;
    }

    public void setTxtcedcamionero(JTextField txtcedcamionero) {
        this.txtcedcamionero = txtcedcamionero;
    }

    public JTextField getTxtcedcliente() {
        return txtcedcliente;
    }

    public void setTxtcedcliente(JTextField txtcedcliente) {
        this.txtcedcliente = txtcedcliente;
    }

    public JTextField getTxtceddestinatario() {
        return txtceddestinatario;
    }

    public void setTxtceddestinatario(JTextField txtceddestinatario) {
        this.txtceddestinatario = txtceddestinatario;
    }

    public JTextField getTxtnomcamionero() {
        return txtnomcamionero;
    }

    public void setTxtnomcamionero(JTextField txtnomcamionero) {
        this.txtnomcamionero = txtnomcamionero;
    }

    public JTextField getTxtnomcliente() {
        return txtnomcliente;
    }

    public void setTxtnomcliente(JTextField txtnomcliente) {
        this.txtnomcliente = txtnomcliente;
    }

    public JTextField getTxtnomdestinatario() {
        return txtnomdestinatario;
    }

    public void setTxtnomdestinatario(JTextField txtnomdestinatario) {
        this.txtnomdestinatario = txtnomdestinatario;
    }

    public JButton getBtnbuscarcamionero() {
        return btnbuscarcamionero;
    }

    public void setBtnbuscarcamionero(JButton btnbuscarcamionero) {
        this.btnbuscarcamionero = btnbuscarcamionero;
    }

    public JButton getBtnbuscarcliente() {
        return btnbuscarcliente;
    }

    public void setBtnbuscarcliente(JButton btnbuscarcliente) {
        this.btnbuscarcliente = btnbuscarcliente;
    }

    public JButton getBtnbuscardestinatario() {
        return btnbuscardestinatario;
    }

    public void setBtnbuscardestinatario(JButton btnbuscardestinatario) {
        this.btnbuscardestinatario = btnbuscardestinatario;
    }

    public JTextField getTxtCodigoProvincia() {
        return txtCodigoProvincia;
    }

    public void setTxtCodigoProvincia(JTextField txtCodigoProvincia) {
        this.txtCodigoProvincia = txtCodigoProvincia;
    }

    public JTextField getTxtcodigoCliente() {
        return txtcodigoCliente;
    }

    public void setTxtcodigoCliente(JTextField txtcodigoCliente) {
        this.txtcodigoCliente = txtcodigoCliente;
    }

    public JTextField getTxtcodigoDestinatario() {
        return txtcodigoDestinatario;
    }

    public void setTxtcodigoDestinatario(JTextField txtcodigoDestinatario) {
        this.txtcodigoDestinatario = txtcodigoDestinatario;
    }

    public JButton getBtncargarCamionero() {
        return btncargarCamionero;
    }

    public void setBtncargarCamionero(JButton btncargarCamionero) {
        this.btncargarCamionero = btncargarCamionero;
    }

    public JButton getBtncargarCliente() {
        return btncargarCliente;
    }

    public void setBtncargarCliente(JButton btncargarCliente) {
        this.btncargarCliente = btncargarCliente;
    }

    public JButton getBtncargarDestinatario() {
        return btncargarDestinatario;
    }

    public void setBtncargarDestinatario(JButton btncargarDestinatario) {
        this.btncargarDestinatario = btncargarDestinatario;
    }

    public JTextField getTxtcodigoCamionero() {
        return txtcodigoCamionero;
    }

    public void setTxtcodigoCamionero(JTextField txtcodigoCamionero) {
        this.txtcodigoCamionero = txtcodigoCamionero;
    }

    public JSpinner getSpinnerPeso() {
        return spinnerPeso;
    }

    public void setSpinnerPeso(JSpinner spinnerPeso) {
        this.spinnerPeso = spinnerPeso;
    }

    public JButton getBtnactualizar() {
        return btnactualizar;
    }

    public void setBtnactualizar(JButton btnactualizar) {
        this.btnactualizar = btnactualizar;
    }

    public JTextField getTxtcodigoPaquete() {
        return txtcodigoPaquete;
    }

    public void setTxtcodigoPaquete(JTextField txtcodigoPaquete) {
        this.txtcodigoPaquete = txtcodigoPaquete;
    }

    public JLabel getLblCodigoPaquete() {
        return lblCodigoPaquete;
    }

    public void setLblCodigoPaquete(JLabel lblCodigoPaquete) {
        this.lblCodigoPaquete = lblCodigoPaquete;
    }

    public JButton getBtnbuscarProvincia() {
        return btnbuscarProvincia;
    }

    public void setBtnbuscarProvincia(JButton btnbuscarProvincia) {
        this.btnbuscarProvincia = btnbuscarProvincia;
    }

    public JButton getBtncargar() {
        return btncargarProvincias;
    }

    public void setBtncargar(JButton btncargar) {
        this.btncargarProvincias = btncargar;
    }

    public JDialog getjDlgProvincias() {
        return jDlgProvincias;
    }

    public void setjDlgProvincias(JDialog jDlgProvincias) {
        this.jDlgProvincias = jDlgProvincias;
    }

    public JTable getJtblaProvinciasjDlg() {
        return jtblaProvinciasjDlg;
    }

    public void setJtblaProvinciasjDlg(JTable jtblaProvinciasjDlg) {
        this.jtblaProvinciasjDlg = jtblaProvinciasjDlg;
    }

    public JButton getBtncargarProvincias() {
        return btncargarProvincias;
    }

    public void setBtncargarProvincias(JButton btncargarProvincias) {
        this.btncargarProvincias = btncargarProvincias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDlgPaquetes = new javax.swing.JDialog();
        pnlprincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblcodcliente = new javax.swing.JLabel();
        lblcedcliente = new javax.swing.JLabel();
        txtnomcliente = new javax.swing.JTextField();
        txtcedcliente = new javax.swing.JTextField();
        lblcliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblcodprovincia = new javax.swing.JLabel();
        lblprovincia = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lblpeso = new javax.swing.JLabel();
        lblsalidapro = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jclsalidapro = new com.toedter.calendar.JDateChooser();
        lblllegadapro = new javax.swing.JLabel();
        jclllegadapro = new com.toedter.calendar.JDateChooser();
        lblfecharegistro = new javax.swing.JLabel();
        jclfecharegistro = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        lblcoddestinatario = new javax.swing.JLabel();
        lblceddestinatario = new javax.swing.JLabel();
        lbldestinatario = new javax.swing.JLabel();
        txtnomdestinatario = new javax.swing.JTextField();
        txtceddestinatario = new javax.swing.JTextField();
        lblcodcamionero = new javax.swing.JLabel();
        txtnomcamionero = new javax.swing.JTextField();
        lbcedcamionero = new javax.swing.JLabel();
        txtcedcamionero = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        lblnomcamionero = new javax.swing.JLabel();
        btnbuscarcliente = new javax.swing.JButton();
        btnbuscardestinatario = new javax.swing.JButton();
        btnbuscarcamionero = new javax.swing.JButton();
        txtCodigoProvincia = new javax.swing.JTextField();
        txtcodigoCliente = new javax.swing.JTextField();
        txtcodigoDestinatario = new javax.swing.JTextField();
        txtcodigoCamionero = new javax.swing.JTextField();
        spinnerPeso = new javax.swing.JSpinner();
        lblCodigoPaquete = new javax.swing.JLabel();
        txtcodigoPaquete = new javax.swing.JTextField();
        txtnombreprovincia = new javax.swing.JTextField();
        btnbuscarProvincia = new javax.swing.JButton();
        jDlgClientes = new javax.swing.JDialog();
        pnlprincipalcli = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblclientes = new javax.swing.JTable();
        btncargarCliente = new javax.swing.JButton();
        jDlgDestinatario = new javax.swing.JDialog();
        pblprincipaldes = new javax.swing.JPanel();
        lbltitulo1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldestinatarios = new javax.swing.JTable();
        btncargarDestinatario = new javax.swing.JButton();
        jDlgCamionero = new javax.swing.JDialog();
        pnlprincipalcam = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblcamioneros = new javax.swing.JTable();
        btncargarCamionero = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jDlgProvincias = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtblaProvinciasjDlg = new javax.swing.JTable();
        lbltitulo2 = new javax.swing.JLabel();
        btncargarProvincias = new javax.swing.JButton();
        pnlprincipalframe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btncrear = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapaquetes = new javax.swing.JTable();

        pnlprincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlprincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Información del cliente");

        lblcodcliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcodcliente.setText("Codigo");

        lblcedcliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcedcliente.setText("Cédula:");

        lblcliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcliente.setText("Nombre y Apellido:");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setText("Paquete");

        btnguardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnguardar.setText("Guardar");

        btncancelar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btncancelar.setText("Cancelar");

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel13.setText("Información de la provincia");

        lblcodprovincia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcodprovincia.setText("Codigo");

        lblprovincia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblprovincia.setText("Provincia:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setText("Información del paquete");

        lblpeso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblpeso.setText("Peso:");

        lblsalidapro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblsalidapro.setText("Salida programada:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Kg");

        lblllegadapro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblllegadapro.setText("Llegada programada:");

        lblfecharegistro.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblfecharegistro.setText("Fecha registro:");

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel21.setText("Información del destinatario");

        lblcoddestinatario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcoddestinatario.setText("Codigo");

        lblceddestinatario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblceddestinatario.setText("Cédula:");

        lbldestinatario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbldestinatario.setText("Nombre y Apellido:");

        lblcodcamionero.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblcodcamionero.setText("Codigo");

        lbcedcamionero.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbcedcamionero.setText("Cédula:");

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel27.setText("Información del camionero");

        lblnomcamionero.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblnomcamionero.setText("Nombre y Apellido:");

        btnbuscarcliente.setText("buscar");

        btnbuscardestinatario.setText("buscar");

        btnbuscarcamionero.setText("buscar");

        spinnerPeso.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, 1000.0d, 1.0d));

        lblCodigoPaquete.setText("Código:");

        btnbuscarProvincia.setText("Buscar");

        javax.swing.GroupLayout pnlprincipalLayout = new javax.swing.GroupLayout(pnlprincipal);
        pnlprincipal.setLayout(pnlprincipalLayout);
        pnlprincipalLayout.setHorizontalGroup(
            pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalLayout.createSequentialGroup()
                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lblcliente)
                                        .addGap(5, 5, 5)
                                        .addComponent(txtnomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnbuscardestinatario))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addComponent(lbldestinatario)
                                        .addGap(7, 7, 7)
                                        .addComponent(txtnomdestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13)
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addComponent(lblcodcliente)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addComponent(lblcedcliente)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtcedcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblprovincia)
                                            .addComponent(lblcodprovincia))
                                        .addGap(36, 36, 36)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnombreprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addComponent(txtCodigoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnbuscarProvincia))))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblceddestinatario)
                                            .addComponent(lblcoddestinatario))
                                        .addGap(47, 47, 47)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(txtceddestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtcodigoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(45, 45, 45)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnbuscarcamionero))
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addComponent(lblnomcamionero)
                                                .addGap(7, 7, 7)
                                                .addComponent(txtnomcamionero, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel15))))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcedcamionero)
                                            .addComponent(lblcodcamionero))
                                        .addGap(71, 71, 71)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcedcamionero, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcodigoCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addComponent(lblpeso)
                                                .addGap(18, 18, 18)
                                                .addComponent(spinnerPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel18))
                                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblllegadapro)
                                                    .addComponent(lblsalidapro))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jclsalidapro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jclllegadapro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnbuscarcliente)
                                        .addGap(570, 570, 570))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlprincipalLayout.createSequentialGroup()
                                        .addComponent(lblCodigoPaquete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(lblfecharegistro)
                                        .addGap(18, 18, 18)))
                                .addComponent(jclfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnguardar)
                        .addGap(633, 633, 633)
                        .addComponent(btncancelar))
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(jLabel2)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlprincipalLayout.setVerticalGroup(
            pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnbuscarcliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodcliente)
                            .addComponent(txtcodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblcedcliente))
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcedcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlprincipalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblcliente))
                            .addComponent(txtnomcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(btnbuscardestinatario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcoddestinatario)
                            .addComponent(txtcodigoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtceddestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblceddestinatario))
                        .addGap(20, 20, 20)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldestinatario)
                            .addComponent(txtnomdestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(9, 9, 9)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodprovincia)
                            .addComponent(txtCodigoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarProvincia))
                        .addGap(7, 7, 7)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprovincia)
                            .addComponent(txtnombreprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlprincipalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblfecharegistro)
                                .addComponent(lblCodigoPaquete)
                                .addComponent(txtcodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jclfecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblpeso)
                            .addComponent(spinnerPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(40, 40, 40)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsalidapro)
                            .addComponent(jclsalidapro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jclllegadapro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblllegadapro))
                        .addGap(56, 56, 56)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(btnbuscarcamionero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcodcamionero)
                            .addComponent(txtcodigoCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedcamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcedcamionero))
                        .addGap(20, 20, 20)
                        .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnomcamionero)
                            .addComponent(txtnomcamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDlgPaquetesLayout = new javax.swing.GroupLayout(jDlgPaquetes.getContentPane());
        jDlgPaquetes.getContentPane().setLayout(jDlgPaquetesLayout);
        jDlgPaquetesLayout.setHorizontalGroup(
            jDlgPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDlgPaquetesLayout.setVerticalGroup(
            jDlgPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgPaquetesLayout.createSequentialGroup()
                .addComponent(pnlprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlprincipalcli.setBackground(new java.awt.Color(255, 255, 255));

        lbltitulo.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbltitulo.setText("Listado de Clientes");

        tblclientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "DNI", "Nombre", "Apellido"
            }
        ));
        jScrollPane2.setViewportView(tblclientes);

        btncargarCliente.setText("Cargar");

        javax.swing.GroupLayout pnlprincipalcliLayout = new javax.swing.GroupLayout(pnlprincipalcli);
        pnlprincipalcli.setLayout(pnlprincipalcliLayout);
        pnlprincipalcliLayout.setHorizontalGroup(
            pnlprincipalcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalcliLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btncargarCliente)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlprincipalcliLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitulo)
                .addGap(224, 224, 224))
        );
        pnlprincipalcliLayout.setVerticalGroup(
            pnlprincipalcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalcliLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(lbltitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlprincipalcliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarCliente))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jDlgClientesLayout = new javax.swing.GroupLayout(jDlgClientes.getContentPane());
        jDlgClientes.getContentPane().setLayout(jDlgClientesLayout);
        jDlgClientesLayout.setHorizontalGroup(
            jDlgClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgClientesLayout.createSequentialGroup()
                .addComponent(pnlprincipalcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDlgClientesLayout.setVerticalGroup(
            jDlgClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipalcli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pblprincipaldes.setBackground(new java.awt.Color(255, 255, 255));

        lbltitulo1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbltitulo1.setText("Listado de Destinatario");

        tbldestinatarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbldestinatarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cód", "DNI", "Nombre", "Apellido"
            }
        ));
        jScrollPane3.setViewportView(tbldestinatarios);

        btncargarDestinatario.setText("Cargar");

        javax.swing.GroupLayout pblprincipaldesLayout = new javax.swing.GroupLayout(pblprincipaldes);
        pblprincipaldes.setLayout(pblprincipaldesLayout);
        pblprincipaldesLayout.setHorizontalGroup(
            pblprincipaldesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblprincipaldesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncargarDestinatario)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pblprincipaldesLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(lbltitulo1)
                .addGap(224, 224, 224))
        );
        pblprincipaldesLayout.setVerticalGroup(
            pblprincipaldesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblprincipaldesLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(lbltitulo1)
                .addGap(18, 18, 18)
                .addGroup(pblprincipaldesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarDestinatario))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jDlgDestinatarioLayout = new javax.swing.GroupLayout(jDlgDestinatario.getContentPane());
        jDlgDestinatario.getContentPane().setLayout(jDlgDestinatarioLayout);
        jDlgDestinatarioLayout.setHorizontalGroup(
            jDlgDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgDestinatarioLayout.createSequentialGroup()
                .addComponent(pblprincipaldes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDlgDestinatarioLayout.setVerticalGroup(
            jDlgDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pblprincipaldes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlprincipalcam.setBackground(new java.awt.Color(255, 255, 255));

        tblcamioneros.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblcamioneros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cód", "DNI", "Nombre", "Apellido"
            }
        ));
        jScrollPane4.setViewportView(tblcamioneros);

        btncargarCamionero.setText("Cargar");

        javax.swing.GroupLayout pnlprincipalcamLayout = new javax.swing.GroupLayout(pnlprincipalcam);
        pnlprincipalcam.setLayout(pnlprincipalcamLayout);
        pnlprincipalcamLayout.setHorizontalGroup(
            pnlprincipalcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalcamLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncargarCamionero)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        pnlprincipalcamLayout.setVerticalGroup(
            pnlprincipalcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprincipalcamLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlprincipalcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarCamionero))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jDlgCamioneroLayout = new javax.swing.GroupLayout(jDlgCamionero.getContentPane());
        jDlgCamionero.getContentPane().setLayout(jDlgCamioneroLayout);
        jDlgCamioneroLayout.setHorizontalGroup(
            jDlgCamioneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDlgCamioneroLayout.createSequentialGroup()
                .addComponent(pnlprincipalcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDlgCamioneroLayout.setVerticalGroup(
            jDlgCamioneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipalcam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtblaProvinciasjDlg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ));
        jScrollPane5.setViewportView(jtblaProvinciasjDlg);

        lbltitulo2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbltitulo2.setText("Listado de provincias");

        btncargarProvincias.setText("Cargar");

        javax.swing.GroupLayout jDlgProvinciasLayout = new javax.swing.GroupLayout(jDlgProvincias.getContentPane());
        jDlgProvincias.getContentPane().setLayout(jDlgProvinciasLayout);
        jDlgProvinciasLayout.setHorizontalGroup(
            jDlgProvinciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDlgProvinciasLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncargarProvincias)
                .addContainerGap())
            .addGroup(jDlgProvinciasLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lbltitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDlgProvinciasLayout.setVerticalGroup(
            jDlgProvinciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDlgProvinciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo2)
                .addGap(18, 18, 18)
                .addGroup(jDlgProvinciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarProvincias))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlprincipalframe.setBackground(new java.awt.Color(153, 153, 153));
        pnlprincipalframe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar:");
        pnlprincipalframe.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, -1, -1));
        pnlprincipalframe.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 33, 195, -1));

        btncrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncrear.setText("Crear");
        btncrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlprincipalframe.add(btncrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 88, -1));

        btnmodificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlprincipalframe.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 90, -1));

        btneliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlprincipalframe.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        btnactualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlprincipalframe.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        tablapaquetes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablapaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código de registro", "Fecha de registro", "Código del destinatario", "Nombre y apellido", "Código del cliente", "Nombre y apellido"
            }
        ));
        jScrollPane1.setViewportView(tablapaquetes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(pnlprincipalframe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlprincipalframe, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscarProvincia;
    private javax.swing.JButton btnbuscarcamionero;
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btnbuscardestinatario;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncargarCamionero;
    private javax.swing.JButton btncargarCliente;
    private javax.swing.JButton btncargarDestinatario;
    private javax.swing.JButton btncargarProvincias;
    private javax.swing.JButton btncrear;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JDialog jDlgCamionero;
    private javax.swing.JDialog jDlgClientes;
    private javax.swing.JDialog jDlgDestinatario;
    private javax.swing.JDialog jDlgPaquetes;
    private javax.swing.JDialog jDlgProvincias;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jclfecharegistro;
    private com.toedter.calendar.JDateChooser jclllegadapro;
    private com.toedter.calendar.JDateChooser jclsalidapro;
    private javax.swing.JTable jtblaProvinciasjDlg;
    private javax.swing.JLabel lbcedcamionero;
    private javax.swing.JLabel lblCodigoPaquete;
    private javax.swing.JLabel lblcedcliente;
    private javax.swing.JLabel lblceddestinatario;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblcodcamionero;
    private javax.swing.JLabel lblcodcliente;
    private javax.swing.JLabel lblcoddestinatario;
    private javax.swing.JLabel lblcodprovincia;
    private javax.swing.JLabel lbldestinatario;
    private javax.swing.JLabel lblfecharegistro;
    private javax.swing.JLabel lblllegadapro;
    private javax.swing.JLabel lblnomcamionero;
    private javax.swing.JLabel lblpeso;
    private javax.swing.JLabel lblprovincia;
    private javax.swing.JLabel lblsalidapro;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltitulo1;
    private javax.swing.JLabel lbltitulo2;
    private javax.swing.JPanel pblprincipaldes;
    private javax.swing.JPanel pnlprincipal;
    private javax.swing.JPanel pnlprincipalcam;
    private javax.swing.JPanel pnlprincipalcli;
    private javax.swing.JPanel pnlprincipalframe;
    private javax.swing.JSpinner spinnerPeso;
    private javax.swing.JTable tablapaquetes;
    private javax.swing.JTable tblcamioneros;
    private javax.swing.JTable tblclientes;
    private javax.swing.JTable tbldestinatarios;
    private javax.swing.JTextField txtCodigoProvincia;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedcamionero;
    private javax.swing.JTextField txtcedcliente;
    private javax.swing.JTextField txtceddestinatario;
    private javax.swing.JTextField txtcodigoCamionero;
    private javax.swing.JTextField txtcodigoCliente;
    private javax.swing.JTextField txtcodigoDestinatario;
    private javax.swing.JTextField txtcodigoPaquete;
    private javax.swing.JTextField txtnombreprovincia;
    private javax.swing.JTextField txtnomcamionero;
    private javax.swing.JTextField txtnomcliente;
    private javax.swing.JTextField txtnomdestinatario;
    // End of variables declaration//GEN-END:variables
}
