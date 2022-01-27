package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.BankController;
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
public class EnhetstestBankController {

    @InjectMocks
    // denne skal testes
    private BankController bankController;

    @Mock
    // denne skal Mock'es
    private BankRepository repository;

    @Mock
    // denne skal Mock'es
    private Sikkerhet sjekk;

    //WiP
    @Test
    public void hentTransaksjoner_loggetInn(){

    }

    //WiP
    @Test
    public void hentTransaksjoner_ikkeLoggetInn(){

    }

    @Test
    public void hentKundeInfo_loggetInn() {

        // arrange
        Kunde enKunde = new Kunde("01010110523",
                "Lene", "Jensen", "Askerveien 22", "3270",
                "Asker", "22224444", "HeiHei");

        when(sjekk.loggetInn()).thenReturn("01010110523");

        when(repository.hentKundeInfo(anyString())).thenReturn(enKunde);

        // act
        Kunde resultat = bankController.hentKundeInfo();

        // assert
        assertEquals(enKunde, resultat);
    }

    @Test
    public void hentKundeInfo_IkkeloggetInn() {

        // arrange
        when(sjekk.loggetInn()).thenReturn(null);

        //act
        Kunde resultat = bankController.hentKundeInfo();

        // assert
        assertNull(resultat);
    }

    @Test
    public void hentKonti_LoggetInn()  {
        // arrange
        List<Konto> konti = new ArrayList<>();
        Konto konto1 = new Konto("105010123456", "01010110523",
                720, "Lønnskonto", "NOK", null);
        Konto konto2 = new Konto("105010123456", "12345678901",
                1000, "Lønnskonto", "NOK", null);
        konti.add(konto1);
        konti.add(konto2);

        when(sjekk.loggetInn()).thenReturn("01010110523");

        when(repository.hentKonti(anyString())).thenReturn(konti);

        // act
        List<Konto> resultat = bankController.hentKonti();

        // assert
        assertEquals(konti, resultat);
    }

    @Test
    public void hentKonti_IkkeLoggetInn()  {
        // arrange

        when(sjekk.loggetInn()).thenReturn(null);

        // act
        List<Konto> resultat = bankController.hentKonti();

        // assert
        assertNull(resultat);
    }

       @Test
    public void hentTransaksjonerLoggetInn() {

        // arrange
        Konto enKonto = new Konto("105010123456", "12345678901",
                1000, "Lønnskonto", "NOK", null);

        String fraDato = "kamel";

        String tilDato = "dromedar";

        when(sjekk.loggetInn()).thenReturn("12345678901");

        when(repository.hentTransaksjoner("12345678901", fraDato, tilDato)).thenReturn(enKonto);

        // act
        Konto resultat = bankController.hentTransaksjoner("12345678901", fraDato, tilDato);

        // assert
        assertEquals(enKonto, resultat);
    }

    @Test
    public void hentTransaksjonerIkkeloggetInn() {

        // arrange
        when(sjekk.loggetInn()).thenReturn(null);

        //act
        Konto resultat = bankController.hentTransaksjoner("runa", "hacker", "alt");

        // assert
        assertNull(resultat);

    }

    //Hent Saldi
    //SJEKK OM DISSE KJØRER
    @Test
    public void hentSaldiLoggetInn()  {
       
        // arrange
        List<Konto> saldi = new ArrayList<>();
        Konto konto1 = new Konto("105010123456", "01010110523",
                20320, "Lønnskonto", "NOK", null);
        Konto konto2 = new Konto("105010123456", "12345678901",
                10000, "Sparekonto", "NOK", null);
        saldi.add(konto1);
        saldi.add(konto2);

        when(sjekk.loggetInn()).thenReturn("01010110523");

        when(repository.hentKonti("01010110523")).thenReturn(saldi);

        // act
        List<Konto> resultat = bankController.Konti();

        // assert
        assertEquals(saldi, resultat);
    }

    @Test
    public void hentSaldiIkkeLoggetInn() {

        //arrange
        when(sjekk.loggetInn()).thenReturn(null);
        
        //act
        List<Konto> resultat = bankController.hentSaldi();

        //assert
        assertNull(resultat);
    }

    //Registrere betaling
    //SJEKK OM DISSE KJØRER
    @Test
    public void registrerBetalingLoggetInn() {

        //arrange
       Transaksjon betaling = new Transaksjon (3, "1243567483 til 234859300", 904, "kamel", "Middag på byen", "avventer", "1243567483");

        when(sjekk.loggetInn()).thenReturn("01234567891");
        when(repository.registrerBetaling("01234567891")).thenReturn(betaling);

        //act
        Transaksjon resultat = bankController.registrerBetaling(betaling);

        //assert
        assertEquals("Betaling registrert", resultat);
    }

    @Test
    public void registrerBetalingIkkeLoggetInn() {
        
    }

    //Hent betalinger
    //SJEKK OM DISSE KJØRER

    @Test
    public void hentBetalingerLoggetInn() {

    }

    //Utfør betalinger
    //
}

