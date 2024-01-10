import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {
    @Test
    fun testQuotaVariable(){
        var expected = 0.15
        assertEquals(expected, quotaVariable(50))

        expected = 0.0
        assertEquals(expected, quotaVariable(25))

        expected = 0.3
        assertEquals(expected, quotaVariable(201))
    }

    @Test
    fun testDescompteFamiliaNombrosaOMonomarental(){
        var expected = 0.4
        assertEquals(expected, descompteFamiliaNombrosaOMonomarental(true,4))

        expected = 0.0
        assertEquals(expected, descompteFamiliaNombrosaOMonomarental(false, 1))

        expected = 0.5
        assertEquals(expected, descompteFamiliaNombrosaOMonomarental(true, 14))
    }

    @Test
    fun testDescompteBoSocial(){
        var expected = 0.0
        assertEquals(expected, descompteBoSocial(false))

        expected = 0.8
        assertEquals(expected, descompteBoSocial(true))
    }
}