package cc.roberto.easygoband.domain;

import java.util.Formatter;
import java.util.Objects;

/**
 * Imprime en un String un {@code Parent} con todos sus datos.
 */
public class ParentPrinter {

    public static String print(Parent parent) {
        Objects.requireNonNull(parent);
        
        @SuppressWarnings("resource")
        Formatter formatter = new Formatter();
        
        formatter.format("Parent\n");
        formatter.format("  accessGroupName: %s\n", parent.getAccessGroupName());
        formatter.format("  accessGroupId: %d\n", parent.getAccessGroupId());
        formatter.format("  accessGroupName: %s\n", parent.getTotalUses());
        formatter.format("  sessions:\n");
        parent.getSessions().forEach(s -> {
            formatter.format("    Session\n");
            formatter.format("      name: %s\n", s.getName());
            formatter.format("      id: %d\n", s.getId());
        });
        formatter.format("  eventId: %s\n", parent.getEventId());
        formatter.format("  structureDecode: %s\n", parent.isStructureDecode());
        formatter.format("  name: %s\n", parent.getName());
        formatter.format("  modified: %s\n", parent.getModified());
        formatter.format("  id: %s\n", parent.getId());
        formatter.format("  basicProductId: %s\n", parent.getBasicProductId());
        
        return formatter.toString();
    }
}
