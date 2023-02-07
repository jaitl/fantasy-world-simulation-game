package pro.jaitl.game.entity;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    private final UUID id = UUID.randomUUID();
    private final String name;

    public String getName() {
        return name;
    }

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entity other = (Entity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [name=" + name + "]";
    }
}
