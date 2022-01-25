package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.AdminKundeController;
import oslomet.testing.API.BankController;
import oslomet.testing.DAL.AdminRepository;
import oslomet.testing.DAL.BankRepository;
import oslomet.testing.Models.Konto;
import oslomet.testing.Models.Kunde;
import oslomet.testing.Sikkerhet.Sikkerhet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestAdminKundeController {

    @InjectMocks
    private AdminKundeController adminKundeController;

    @Mock
    private AdminRepository rep;

    @Mock
    private Sikkerhet sjekk;


    //-------TESTS--------//
        // -NB! Dobbeltsjekk at ikke logget inne er gjort riktig

    //---hentAlle---//
    //DONE
    @Test
    public void hentAlle_ikkeLoggetInn(){

        // arrange
        when(sjekk.loggetInn()).thenReturn(null); //Later som vi kjører metoden og tvinger frem "null" resultat

        // act
        List<Kunde> resultat = adminKundeController.hentAlle(); //Bruker hentAlle metoden

        // assert
        assertNull(resultat); //Metode som sjekker at man får forventet svar - her null
    }

    //DONE
    @Test
    public void hentAlle_loggetInn(){
        // arrange
        Kunde kunde1 = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");
        Kunde kunde2 = new Kunde("12345678901",
                "Per", "Hansen", "Osloveien 82", "1234",
                "Oslo", "12345678", "HeiHei");
        //Vi skal teste en liste og derfor må vi opprette mer enn én person å teste på

        List<Kunde> alleKunder = new ArrayList<>();
        alleKunder.add(kunde1);
        alleKunder.add(kunde2);

        when(sjekk.loggetInn()).thenReturn("Admin"); //Later som vi logger inn
        when(rep.hentAlleKunder()).thenReturn(alleKunder); //Later som listen alleKunder vi laget eksisterer i rep

        assertEquals(alleKunder, adminKundeController.hentAlle());
    }

    //---lagreKunde---//
    //DONE
    @Test
    public void lagreKunde_ikkeLoggetInn(){
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei"); //arrange

        when(sjekk.loggetInn()).thenReturn(null); //arrange

        String resultat = adminKundeController.lagreKunde(enKunde); //act

        assertEquals("Ikke logget inn", resultat); //assert - resultatet du fikk er forventet
    }
    @Test
    public void lagreKunde_loggetInn(){
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");
    }

    //---endre---//
    //DONE
    @Test
    public void endre_ikkeLoggetInn(){

        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn(null);

        String resultat = adminKundeController.endre(enKunde);

        assertEquals("Ikke logget inn", resultat);
    }
    @Test
    public void endre_loggetInn(){
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");
    }

    //---slett---//
    //DONE
    @Test
    public void slett_ikkeLoggetInn(){
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn(null);

        String resultat = adminKundeController.slett(enKunde.getPersonnummer());

        assertEquals("Ikke logget inn", resultat);
    }
    @Test
    public void slett_loggetInn(){
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");
    }
}
