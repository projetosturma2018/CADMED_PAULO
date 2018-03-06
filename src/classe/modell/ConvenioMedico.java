
package classe.modell;

import java.util.Objects;

/**
 *
 * @author PauloGouveia
 */
public class ConvenioMedico {

    private String nomeConvenio;
    private int idConvenio;

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Override
    public String toString() {
        return "ConvenioMedico{" + "nomeConvenio=" + nomeConvenio + ", idConvenio=" + idConvenio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.nomeConvenio);
        hash = 31 * hash + this.idConvenio;
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
        final ConvenioMedico other = (ConvenioMedico) obj;
        return true;
    }
    
}
