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
import oslomet.testing.Models.Transaksjon;
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
        List<Konto> resultat = bankController.hentSaldi();

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

    //Registrer betaling
    //Fiks denne!
    @Test
    public void registrerBetalingLoggetInn() {

        //arrange
       Transaksjon betaling = new Transaksjon (3, "1243567483 til 234859300", 904,
               "kamel", "Middag på byen", "avventer", "1243567483");

        when(sjekk.loggetInn()).thenReturn("01234567891");
        when(repository.registrerBetaling(betaling)).thenReturn("OK");

        //act
        String resultat = bankController.registrerBetaling(betaling);

        //assert
        assertEquals("OK", resultat);
    }

    @Test
    public void registrerBetalingIkkeLoggetInn() {
        
    }

    //Hent betalinger

    @Test
    public void hentBetalingerLoggetInn() {

        //arrange
        List<Transaksjon> betalinger = new ArrayList<>();
        Transaksjon betaling1 = new Transaksjon(1, "23847564599 til 76958473652", 506.99,
                "01.11.2021", "Mobilabonnement", "avventer", "76958473652");
        Transaksjon betaling2 = new Transaksjon(2, "23847564599 til 76958473652", 67.50,
                "07.01.2022", "Ukelønn", "avventer", "76958473652");
        Transaksjon betaling3 = new Transaksjon(3, "1243567483 til 234859300", 904,
                "kamel", "Middag på byen", "avventer", "76958473652");
        betalinger.add(betaling1);
        betalinger.add(betaling2);
        betalinger.add(betaling3);

        when(sjekk.loggetInn()).thenReturn("09059445763");
        when(repository.hentBetalinger("09059445763")).thenReturn(betalinger);

        //act
        List<Transaksjon> resultat = bankController.hentBetalinger();

        //assert
        assertEquals(betalinger, resultat);
    }

    //Utfør betalinger
    //Endre kundeinfo
}

