import android.app.Activity;
import android.os.Bundle;

public class ChuaThanhToanActivity extends App {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Đặt giao diện cho tab "Chưa thanh toán" ở đây
        setContentView(R.layout.activity_chua_thanh_toan); // Thay R.layout.activity_chua_thanh_toan bằng layout của bạn
    }
}

