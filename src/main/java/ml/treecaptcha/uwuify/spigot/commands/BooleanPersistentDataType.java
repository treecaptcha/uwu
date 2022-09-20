package ml.treecaptcha.uwuify.spigot.commands;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class BooleanPersistentDataType implements PersistentDataType<String, Boolean> {

        public static final BooleanPersistentDataType INSTANCE = new BooleanPersistentDataType();

        public BooleanPersistentDataType() {
            
        }

        @Override
        public @NotNull Class<String> getPrimitiveType() {
            return String.class;
        }

        @Override
        public @NotNull Class<Boolean> getComplexType() {
            return Boolean.class;
        }

        @Override
        public @NotNull String toPrimitive(@NotNull Boolean aBoolean, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
            return aBoolean.toString();
        }

        @Override
        public @NotNull Boolean fromPrimitive(@NotNull String s, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
            return Boolean.parseBoolean(s);
        }
}
