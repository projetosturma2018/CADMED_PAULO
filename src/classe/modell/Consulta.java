
package classe.modell;

import java.util.Objects;

/**
 *
 * @author PauloGouveia
 */
public class Consulta {
    
    private int idConulta;
    private String historico;
    private String patologia;

    public int getIdConulta() {
        return idConulta;
    }

    public void setIdConulta(int idConulta) {
        this.idConulta = idConulta;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idConulta;
        hash = 17 * hash + Objects.hashCode(this.historico);
        hash = 17 * hash + Objects.hashCode(this.patologia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConulta=" + idConulta + ", historico=" + historico + ", patologia=" + patologia + '}';
    }
    
}
