package com.tranphukhag.mathutil.core.test;

import static com.tranphukhag.mathutil.core.MathUtility.*;
//hàm static đc gọi như bình thường => import kiểu static
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityTest {
    //Test Case #3 : Check getFactorial() with n = -5...  to see the Exception
    // Tôi muốn thấy có ngoại lệ xuất hiện trong tình huống n âm hoặc n > 20
    // ngoại lệ có xh như dự kiến hay ko .... nếu có thì phải là màu xanh !!!!
    //NGHE KĨ :CÓ NGOẠI LỆ , NHƯNG LÀ MÀU XANH , V NGOẠI LỆ XH NHƯ DỰ KIẾN
    @Test
    void testFactorialGivenWrongArgumentThrowsException() {
      //  getFactorial(-5);
        assertThrows(IllegalArgumentException.class,() -> {getFactorial(-5);});
        assertThrows(IllegalArgumentException.class,() -> {getFactorial(    22);});
    }
    //Test Case #2 : Check getFactorial() with n = 5 to see result of 120
    @Test
    void testFactorialGivenRightArgument5RunsWell(){
        assertEquals(1,getFactorial(1));
        assertEquals(2,getFactorial(2));
        assertEquals(6,getFactorial(3));
        assertEquals(24,getFactorial(4));
        assertEquals(120,getFactorial(5));
        assertEquals(720,getFactorial(6));
    }

    //Cấu trúc test case : Id ,Des , Steps/Procedures , Expected Result ,
    //                      Actual Réults , Status , passed , failed
    //                      Test date  , bug # (bug id ) Bugzilla ( Bug DB )
    //                                                      Jira
    //Test Case #1 : Check getFactorial() with n = 0 to see result of 1
    //
    @Test
    void testFactorialGivenRightArgument0RunsWell() {
        long expectedValue = 1 ; // hy vong 0! trả về 1
        long actualValue = getFactorial(0);
        //So sánh
        //Truyền thống ta sout() in kết quả và nhìn = mắt để đoán đúng sai
        // hiện đại : xài thêm tool , thư viện , unit testing frame work JUnit
        //giúp đôi mắt ta nhìn KẾT QUẢ ĐÚNG SAI 2 MÀU XANH VÀ MÀU ĐỎ
        //NÃO VÀ MẮT KO CẦN NHÌN , ĐOÁN VÀ KẾT LUẬN NHƯ TRUYỀN THỐNG
        // MÀ NAY THẤYY ĐỎ ==> TẠCH , XANH => ỔN
        assertEquals(expectedValue, actualValue);
        //      giống nhau màu xanh , lệch nhau màu đỏ hàm chạy ko ra kêt quả như mong đợi
    }

}

//QUY TẮC XANH ĐỎ CỦA UNIT TEST TOOL/FRAMEWORK
//NẾU TẤT CẢ CÁC TEST CASE PASSED (EXPEDTED == ACTUAL ) => MÀU XANH
// CHỈ CẦN 1 TRONG NHỮNG TEST CASE FAILED ( EXPECTED != ACTUAL ) => MÀU ĐỎ
//LÝ DO : HÀM ĐÃ ĐÚNG THÌ PHẢI ĐÚNG HẾT VỚI CÁC TEST CASE ĐÃ ĐƯA RA !!
// MẮT CHỈ NHÌN 2 TÍN HIỆU - XANH , ĐỎ THEO STYLE GỘP CÁC KẾT QUẢ
//XANH : ĐÚNG HẾT , ĐỎ : 1 THẰNG NÀO CHẾT -> BỎ HÀM , FIX LẠI !!!!

//KĨ THUẬT VIẾT CODE CHỈNH ( HÀM TRONG API , CORE ..... )
// MÀ ĐI KÈM CODE TEST HÀM LUÔN . DÙNG 2 TRẠNG THÁI XANH ĐỎ ,CỨ LIÊN TỤC CODE
//XONG CHẠY XANH ĐỎ , SỮA ,CHẠY LẠI XANH ĐỎ , TỐI ƯU CHỈNH CODE , CHẠY LẠI XANH
//ĐỎ ,XANH ĐỎ LIÊN TỤC TRONG QUÁ TRÌNH VIẾT CODE ĐC GỌI LÀ TDD
//TEST DRIVEN DEVELOPMENT  - VIẾT CODE SONG HÀNH CÙNG CODE TEST
