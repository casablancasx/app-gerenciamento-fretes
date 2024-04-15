package io.github.danchaves.msfrete.service.interfaces.impl;

import io.github.danchaves.msfrete.enums.StatusPagamento;
import io.github.danchaves.msfrete.models.Frete;
import io.github.danchaves.msfrete.service.interfaces.IsetStatus;
import org.springframework.stereotype.Component;


@Component
public class setStatusImpl implements IsetStatus {

    @Override
    public void setStaus(Frete frete) {

        double diferenca = frete.getValorTotal() - frete.getValorPago();


        if (frete.getValorPago().equals(frete.getValorTotal())){
            frete.setStatus(StatusPagamento.PAGO);
        }else if (frete.getValorTotal() > frete.getValorPago() && frete.getValorPago() > 0.0){
            frete.setStatus(StatusPagamento.INCOMPLETO);
        }else {
            frete.setStatus(StatusPagamento.NAO_REALIZADO);
        }
    }
}
