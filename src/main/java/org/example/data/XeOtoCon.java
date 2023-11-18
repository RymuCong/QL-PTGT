package org.example.data;

public class XeOtoCon extends Vehicle{
    private int dungTichDongCo;
    private int dungTichCop;
    public String loaiXe = "XeOtoCon";

    public XeOtoCon(String loaiXe, String tenPhuongTien, String hangSanXuat, int namSanXuat, double giaTien, float lePhiTruocBa, String maSoThue, String tenNguoiKhaiThue, int dungTichDongCo, int dungTichCop) {
        super(loaiXe, tenPhuongTien, hangSanXuat, namSanXuat, giaTien, lePhiTruocBa, maSoThue, tenNguoiKhaiThue);
        this.dungTichDongCo = dungTichDongCo;
        this.dungTichCop = dungTichCop;
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
