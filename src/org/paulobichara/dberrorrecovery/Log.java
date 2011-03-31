/*
   Copyright 2011 Paulo Augusto Dacach Bichara

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.paulobichara.dberrorrecovery;

import java.util.*;

public class Log {

    private ArrayList historico;

    public Log() {
        historico = new ArrayList();
    }

    public String InsereOperacao(String t, String var, int val) {
        Registro reg = new Registro(t, var, val);
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereErro() {
        Registro reg = new Registro("ERRO");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereCommit(String t) {
        Registro reg = new Registro(t, "COMMIT");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereCheckpoint() {
        Registro reg = new Registro("CHECKPOINT");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public String insereStart(String t) {
        Registro reg = new Registro(t, "START");
        historico.add(reg);
        return reg.getRegistro()+"\n";
    }

    public int getTamanhoLog() {
        return historico.size();
    }

    public Registro getRegistro(int i) {
        return (Registro)historico.get(i);
    }

    public void resetarLog() {
        historico.clear();
    }

}
