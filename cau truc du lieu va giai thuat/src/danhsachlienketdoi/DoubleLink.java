    package danhsachlienketdoi;

    import danhsachlienketdon.Node;

    public class DoubleLink {
        private String hoTen;
        private String maSV;
        private double diem;
        private String kq, xl;
        public DoubleLink next, prev;
        //

        public DoubleLink(String hoTen, String maSV, double diem) {
            this.hoTen = hoTen;
            this.maSV = maSV;
            this.diem = diem;
            this.next = null;
            this.prev = null;
        }

        public String getHoTen() {
            return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public String getMaSV() {
            return maSV;
        }

        public void setMaSV(String maSV) {
            this.maSV = maSV;
        }

        public double getDiem() {
            return diem;
        }

        public void setDiem(double diem) {
            this.diem = diem;
        }
        //

    }
