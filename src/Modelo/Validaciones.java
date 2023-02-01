package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    
        //Validar poblacion
    public boolean validarTextoConEspacio(String cadena) {
        cadena = cadena.trim();
        boolean validar = cadena.matches("[A-Za-z\\s]*");
        return validar;
    }

    //Validar direccion
    public boolean validarDireccion(String direccion) {
        direccion = direccion.trim();//trim()
        boolean validar = direccion.matches("([\\w\\s]+\\-*+\\#*+\\.*)*");
        return validar;
    }

    //Validar telefono
    public boolean validarTelefono(String telefono) {
        boolean validar = false;
        if (telefono.matches("[0-9]{10}")) {
            validar = true;
        }
        return validar;
    }

    //Validar cedula
    public boolean validarCedula(String cedula) {
        boolean validar = false;
        //Divide la cadena en los 10 numeros
        //Integer.parseInt sirve para transformar una cadena a entero. 
        //subString es un metodo de string(Desde, hasta)
        if (cedula.matches("\\d{10}")) {
            int d1 = Integer.parseInt(cedula.substring(0, 1));
            int d2 = Integer.parseInt(cedula.substring(1, 2));
            int d3 = Integer.parseInt(cedula.substring(2, 3));
            int d4 = Integer.parseInt(cedula.substring(3, 4));
            int d5 = Integer.parseInt(cedula.substring(4, 5));
            int d6 = Integer.parseInt(cedula.substring(5, 6));
            int d7 = Integer.parseInt(cedula.substring(6, 7));
            int d8 = Integer.parseInt(cedula.substring(7, 8));
            int d9 = Integer.parseInt(cedula.substring(8, 9));
            int d10 = Integer.parseInt(cedula.substring(9));

            //Multiplica todas la posciones impares * 2 y las posiciones pares se multiplica 1
            d1 = d1 * 2;
            if (d1 > 9) {
                d1 = d1 - 9;
            }

            d3 = d3 * 2;
            if (d3 > 9) {
                d3 = d3 - 9;
            }

            d5 = d5 * 2;
            if (d5 > 9) {
                d5 = d5 - 9;
            }

            d7 = d7 * 2;
            if (d7 > 9) {
                d7 = d7 - 9;
            }

            d9 = d9 * 2;
            if (d9 > 9) {
                d9 = d9 - 9;
            }

            // SUMA TODOS LOS  NUMEROS PARES E IMPARES
            int sumpar = d2 + d4 + d6 + d8;
            int sumimp = d1 + d3 + d5 + d7 + d9;
            int total = sumpar + sumimp;

            //DIVIDO MI DECENA SUPERIRO PARA 10 Y SI EL RESULTADO ES DIFERENTE DE 0 SUMA 1
            double decenasuperior = total;
            while (decenasuperior % 10 != 0) {
                decenasuperior = decenasuperior + 1;
            }

            if ((decenasuperior - total) == d10) {
                validar = true;
            }
        }

        return validar;
    }

    //Validar nombre y apellido
    public boolean validarTextoSinEspacio(String texto) {

        boolean validar;
        boolean contenedor = true; //Esta variable me sirve para saber si todas las letras del texto ingresado son correctas

        texto = texto.trim();

        if (texto.isEmpty()) {

            validar = false;

        } else {

            if (texto.length() >= 3 && texto.length() <= 20) {//Valido que el texto tenga mas de 3 letras(Tambien acepta vocales mayusculas con tilde)

                for (int i = 0; i < texto.length() && contenedor; i++) { //El for iterara  la longuitud de la palabra y mientras "contenedor" sea true, en caso de "contenedor" ser false saldra del bucle. Ademas i=1 ya que la primera letra ya ha sido valida y ahora solo se validara desde la segunda letra

                    //Valido que el texto cumpla con las letras requeridas(No admite letras mayusculas)
                    if (texto.charAt(i) >= 97 && texto.charAt(i) <= 122 || texto.charAt(i) == 225 || texto.charAt(i) == 233 || texto.charAt(i) == 237 || texto.charAt(i) == 243 || texto.charAt(i) == 250 || texto.charAt(i) == 241 || texto.charAt(i) == 252) {
                        contenedor = true; //En caso de que la letra sea correcta, "contenedor" sera true. Si la letra es incorrecta "contenedor" sera false

                    } else {

                        contenedor = false;
                    }
                }

                if (contenedor) {
                    validar = true;

                } else {
                    validar = false;
                }

            } else {
                validar = false;
            }
        }

        return validar;
    }



    //Validar correo
    public boolean validarCorreo(String mail) {
        boolean val = false;
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,30})$");

        // El email a validar
        Matcher mather = pattern.matcher(mail);
        val = mather.find();

        return val;
    }

    public boolean validarTipoDeLicencia(String licencia) {
        boolean validar = false;
        if (licencia.matches("[A-F]{1}")) {
            validar = true;
        }
        return validar;
    }

    public boolean validarPlaca(String placa) {
        boolean validar = false;
        if (placa.matches("[A-Z]{3}[-][0-9]{3,4}")) {
            validar = true;
        }
        return validar;
    }

    public boolean validarMatricula(String matricula) {
        boolean validar = false;
        if (matricula.matches("[0-9]{7}")) {
            validar = true;
        }
        return validar;
    }

    public boolean validarRuc(String ruc) {
        boolean validar = false;
        if (ruc.matches("[0-9]{13}")) {
            validar = true;
        }
        return validar;
    }

    public boolean validarCodigoPostal(String codigoPostal) {
        boolean validar = false;
        if (codigoPostal.matches("[0-9]{6}")) {
            validar = true;
        }
        return validar;
    }
}
