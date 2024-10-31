package memory;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Memory {
    private long used;

    private long max;

    public Memory(long used, long max) {
        this.used = used;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", max=" + max +
                '}';
    }
}
