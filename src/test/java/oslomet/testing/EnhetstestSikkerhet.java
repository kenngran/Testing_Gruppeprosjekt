package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import oslomet.testing.DAL.BankRepository;
import oslomet.testing.Models.Kunde;
import oslomet.testing.Sikkerhet.Sikkerhet;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EnhetstestSikkerhet {

    @InjectMocks
    private Sikkerhet sjekk;

    @Mock
    private BankRepository repository;

    @Mock
    private HttpSession session;

    @Test
    public void loggInn() {

        // arrange
        when(repository.sjekkLoggInn("01010110523","HeiHei")).thenReturn("OK");

        //act
        String resultatLoggInn = sjekk.sjekkLoggInn("01010110523","HeiHei");

        //assert
        assertEquals("OK", resultatLoggInn);
    }

    @Test
    public void loggetInn() {

        // arrange
        when(sjekk.loggetInn()).thenReturn("01010110523");

        //act
        String resultatLoggInn = sjekk.loggetInn();

        //assert
        assertEquals("01010110523", resultatLoggInn);
    }

    @Test
    public void loggInnAdmin() {

        // arrange

        //act
        String resultatLoggInn = sjekk.loggInnAdmin("Admin","Admin");

        //assert
        assertEquals("Logget inn", resultatLoggInn);
    }
}
