package cc.roberto.easygoband.services;

import java.util.List;

import cc.roberto.easygoband.domain.Parent;

public interface RecruitmentService {

    /**
     * Obtiene todos los {@code Parent}s.
     * 
     * @param sessionName Filtra por el nombre de sesión (opcional).
     * @return La lista con los resultados.
     */
	List<Parent> find(String sessionName);
}
