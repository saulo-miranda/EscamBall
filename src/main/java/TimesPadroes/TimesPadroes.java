package main.java.TimesPadroes;

import main.java.Communication.EscamballService;
import main.java.Models.TimeModel;

import java.io.IOException;

public class TimesPadroes {

    public TimesPadroes(EscamballService service) {
        try
        {
            CriaTimes(service);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private void CriaTimes(EscamballService service) throws IOException{
        TimeModel real = service.CadastroTime("Arthur", "Real", "arthur", "3503");
        if(real != null)
        {
            CriaJogadores(service, real.getTimeId());
        }
        TimeModel psg = service.CadastroTime("Saulo", "PSG", "saulo", "3475");
        if(psg != null)
        {
            CriaJogadores(service, psg.getTimeId());
        }

        if(real != null && psg != null)
        {
            service.CadastroTransacao(1,2,1,5);
            service.CadastroTransacao(1,2,3,7);

            service.CadastroTransacao(2,1,6,2);
            service.CadastroTransacao(2,1,8,4);

        }


    }

    private void CriaJogadores(EscamballService service,int timeId) throws IOException {

        if(timeId==1)
        {
            service.CadastroJogador("Vini Jr", 30,222000, 90,68,80,"ATACANTE", timeId);
            service.CadastroJogador("Rodrygo", 30,120000, 80,75,85,"MEIA", timeId);
            service.CadastroJogador("EderMilitao", 30,60000, 90,85,90,"DEFENSOR", timeId);
            service.CadastroJogador("Cassillas", 30,70000, 90,95,93,"GOLEIRO", timeId);
        }

        if(timeId==2)
        {
            service.CadastroJogador("Neymar", 30,222000, 90,68,80,"ATACANTE", timeId);
            service.CadastroJogador("Messi", 30,120000, 80,75,85,"MEIA", timeId);
            service.CadastroJogador("Sergio Ramos", 30,60000, 90,85,90,"DEFENSOR", timeId);
            service.CadastroJogador("Donnaruma", 30,70000, 90,95,93,"GOLEIRO", timeId);

        }
    }
}
