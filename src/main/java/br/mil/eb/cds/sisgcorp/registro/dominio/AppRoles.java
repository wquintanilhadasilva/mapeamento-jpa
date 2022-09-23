package br.mil.eb.cds.sisgcorp.registro.dominio;

import java.util.Arrays;
import java.util.List;

public enum AppRoles {
    ROOT,
    ADMIN,
    USER;

    public static List<AppRoles> valuesToList() {
        return Arrays.asList(AppRoles.values());
    }

}
