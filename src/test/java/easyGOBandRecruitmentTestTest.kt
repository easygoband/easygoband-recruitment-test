import easyGOBand.Element
import easyGOBand.GetData
import org.junit.jupiter.api.Test as test
import org.assertj.core.api.Assertions.assertThat


class EasyGOBandRecruitmentTestTest {
    @test
    fun getData(){
        val data = GetData()
        data.run()
        val elements: MutableList<Element> = data.elements
        val accessGroupNameList = listOf(
            "Abono", "Jueves", "Viernes", "Sábado", "AAA", "Artista",
            "INV Abono", "INV Jueves", "INV Viernes", "INV Sábado", "ORG", "Prensa", "Staff", "Stage",
            "ACR PK-GENERICO", "VIP Abono", "VIP Jueves", "VIP Viernes", "VIP Sábado",
            "PREMIUM Abono", "PREMIUM Jueves", "PREMIUM Viernes", "PREMIUM Sábado",
            "BUS ABONO", "BUS JUEVES", "BUS VIERNES", "BUS SABADO"
        )

        elements.forEach{
            assertThat(it.id).isBetween(1,999)
            assertThat(it.name).isNotEmpty()
            assertThat(it.accessGroupID).isEqualTo(it.accessGroupID.toInt())
            assertThat(it.accessGroupName).isIn(accessGroupNameList)
            assertThat(it.basicProductID).isBetween(1,999)
            assertThat(it.eventID).isBetween(1,999)
            assertThat(it.structureDecode).isFalse()
            assertThat(it.totalUses).isEqualTo(0)
            assertThat(it.getSessionNames()).isEqualTo(it.getSessionNames().toUpperCase())
        }
    }
}