public class Cliente {
    private String nombre;
    private String tipo; 

    public Cliente(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo.toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
