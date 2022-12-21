package mrskill4ik.fixeasyplacemode.Objects;

import org.bukkit.Material;

public class DataInfo {

    private int X;
    private int Y;
    private int Z;
    private Material BlockClick;

    public DataInfo(int x, int y, int z, Material blockClick) {
        X = x;
        Y = y;
        Z = z;
        BlockClick = blockClick;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getZ() {
        return Z;
    }

    public Material getBlockClick() {
        return BlockClick;
    }
}
