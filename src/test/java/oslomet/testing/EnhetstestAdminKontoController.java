package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import oslomet.testing.API.AdminKontoController;
import oslomet.testing.DAL.AdminRepository;
import oslomet.testing.Models.Konto;
import oslomet.testing.Models.Kunde;
import oslomet.testing.Sikkerhet.Sikkerhet;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestAdminKontoController {

    @InjectMocks
    private AdminKontoController adminKontoController;

    @Mock
    private AdminRepository rep;

    @Mock
    private Sikkerhet sjekk;

    //TESTER

    //WiP
    @Test
    public void hentAlleKonti_ikkeLoggetInn(){
        // arrange
        when(sjekk.loggetInn()).thenReturn(null);

        // act
        List<Konto> resultat = adminKontoController.hentAlleKonti();

        // assert
        assertNull(resultat);
    }

    @Test
    public void hentAlleKonti_loggetInn(){

    }

    @Test
    public void registrerKonto_ikkeLoggetInn(){
        // arrange
        // act
        // assert
    }

    @Test
    public void registrerKonto_loggetInn(){
        // arrange
        // act
        // assert
    }

    @Test
    public void endreKonto_ikkeLoggetInn(){
        // arrange
        // act
        // assert
    }

    @Test
    public void endreKonto_LoggetInn(){
        // arrange
        // act
        // assert
    }

    @Test
    public void slettKonto_ikkeLoggetInn(){
        // arrange
        // act
        // assert
    }

    @Test
    public void slettKonto_loggetInn(){
        // arrange
        // act
        // assert
    }

}

