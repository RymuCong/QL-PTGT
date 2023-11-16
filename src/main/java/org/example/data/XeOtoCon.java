package org.example.data;

public class XeOtoCon extends Vehicle{
    private int dungTichDongCo;
    private int dungTichCop;

    @Override
    public String toString() {
        return "XeOtoCon{" +
                "dungTichDongCo=" + dungTichDongCo +
                ", dungTichCop=" + dungTichCop +
                ", name='" + name + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", giaTien=" + giaTien +
                ", thueTruocBa=" + thueTruocBa +
                '}';
    }

    public XeOtoCon(String name, String hangSanXuat, int namSanXuat, double giaTien, float thueTruocBa) {
        super(name, hangSanXuat, namSanXuat, giaTien, thueTruocBa);
    }

    public int getDungTichDongCo() {
        return dungTichDongCo;
    }

    public void setDungTichDongCo(int dungTichDongCo) {
        this.dungTichDongCo = dungTichDongCo;
    }

    public int getDungTichCop() {
        return dungTichCop;
    }

    public void setDungTichCop(int dungTichCop) {
        this.dungTichCop = dungTichCop;
    }
    
}
