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

        // act
        List<Kunde> resultat = adminKundeController.hentAlle();

        // assert
        assertEquals(alleKunder, resultat);
    }

    //---lagreKunde---//
    //DONE
    @Test
    public void lagreKunde_ikkeLoggetInn(){
        //arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn(null);

        // act
        String resultat = adminKundeController.lagreKunde(enKunde);

        //assert
        assertEquals("Ikke logget inn", resultat);
    }

    @Test
    public void lagreKunde_loggetInn(){
        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn("Admin");
        when(rep.registrerKunde(enKunde)).thenReturn("Kunde lagret");

        // act
        String resultat = adminKundeController.lagreKunde(enKunde);

        // assert
        assertEquals("Kunde lagret", resultat);
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
        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn("Admin");
        when(rep.endreKundeInfo(enKunde)).thenReturn("OK");

        // act
        String resultat = adminKundeController.endre(enKunde);

        // assert
        assertEquals("OK", resultat);
    }

    //---slett---//
    //DONE
    @Test
    public void slett_ikkeLoggetInn(){
        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn(null);

        // act
        String resultat = adminKundeController.slett(enKunde.getPersonnummer());

        // assert
        assertEquals("Ikke logget inn", resultat);
    }
    @Test
    public void slett_loggetInn(){
        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn("Admin");
        when(rep.slettKunde("01010110523")).thenReturn("OK");

        // act
        String resultat = adminKundeController.slett("01010110523");

        // assert
        assertEquals("OK", resultat);
    }
}
