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

public class Registro {

    private String transacao;
    private String variavel;
    private int valorNovo;
    String tipo = new String();
    private String registro;

    public Registro(String t, String var, int val) {
        transacao = t;
        variavel = var;
        valorNovo = val;
        registro = "< "+"WRITE"+": "+transacao+", "+variavel+", "+valorNovo+" >";
        tipo = "WRITE";
    }

    public Registro(String r) {
        registro = "< "+r+" >";
        tipo = r;
    }

    public Registro (String t, String r) {
        transacao = t;
        registro = "< "+r+": "+transacao+" >";
        tipo = r;
    }

    public String getTransaçao() {
        return transacao;
    }

    public String getVariável() {
        return variavel;
    }

    public int GetValorNovo() {
        return valorNovo;
    }

    public String getRegistro() {
        return registro;
    }

    public String getTipo() {
        return tipo;
    }
}
