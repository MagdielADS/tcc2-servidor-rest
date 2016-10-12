/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tcc.util;

import br.edu.ifpb.tcc.model.Local;
import br.edu.ifpb.tcc.model.Mapeamento;
import br.edu.ifpb.tcc.persistencia.GazetteerDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magdiel Ildefonso
 */
public class GerenciadorLocais {

    public static Local geometriaMaisInterna(Mapeamento m) {
        Local local = null;

        if (m.getMunicipio() != null) {
            local = m.getMunicipio();
        } else if (m.getMicrorregiao() != null) {
            local = m.getMicrorregiao();
        } else if (m.getMesorregiao() != null) {
            local = m.getMesorregiao();
        } else if (m.getEstado() != null) {
            local = m.getEstado();
        } else if (m.getRegiao() != null) {
            local = m.getRegiao();
        }

        return local;
    }

    public static Mapeamento construirMapeamento(List<Local> locais) {
        List<Local> locaisExistentes = new ArrayList<>();
        Mapeamento mapeamento = new Mapeamento();

        Local regiao = retiraRegiao(locais);
        if (regiao != null) {
            mapeamento.setRegiao(regiao);
            System.out.println("Região: "+regiao);
        }

        List<Local> util = retiraEstados(locais);
        if (util.size() > 0) {
            if (mapeamento.getRegiao() != null) {
                mapeamento.setEstado(localReferente(mapeamento.getRegiao(), util));

            } else {
                mapeamento.setEstado(util.get(0));
            }
            System.out.println("Estado: "+mapeamento.getEstado());
        }

        util = retiraMesorregioes(locais);
        if (util.size() > 0) {
            if (mapeamento.getEstado() != null) {
                mapeamento.setMesorregiao(localReferente(mapeamento.getEstado(), util));

            } else if (mapeamento.getRegiao() != null) {
                mapeamento.setMesorregiao(localReferente(mapeamento.getRegiao(), util));

            } else {
                mapeamento.setMesorregiao(util.get(0));
            }
            System.out.println("Mesorregiao: "+mapeamento.getMesorregiao());
        }

        util = retiraMicrorregioes(locais);
        if (util.size() > 0) {
            if (mapeamento.getMesorregiao() != null) {
                mapeamento.setMicrorregiao(localReferente(mapeamento.getMesorregiao(), util));
                //mapeamento.setControle(localReferente(mapeamento.getMesorregiao(), util).getNome());
            } else if (mapeamento.getEstado() != null) {
                mapeamento.setMicrorregiao(localReferente(mapeamento.getEstado(), util));
                //mapeamento.setControle(localReferente(mapeamento.getEstado(), util).getNome());
            } else if (mapeamento.getRegiao() != null) {
                mapeamento.setMicrorregiao(localReferente(mapeamento.getRegiao(), util));
                //mapeamento.setControle(localReferente(mapeamento.getRegiao(), util).getNome());
            } else {
                mapeamento.setMicrorregiao(util.get(0));
                //mapeamento.setControle(util.get(0).getNome());
            }
            System.out.println("Microrregiao: "+mapeamento.getMicrorregiao());
        }

        util = retiraMunicipios(locais);
        if (util.size() > 0) {
            if (mapeamento.getMicrorregiao() != null) {
                mapeamento.setMunicipio(localReferente(mapeamento.getMicrorregiao(), util));
                //mapeamento.setControle(localReferente(mapeamento.getMicrorregiao(), util).getNome());
            } else if (mapeamento.getMesorregiao() != null) {
                mapeamento.setMunicipio(localReferente(mapeamento.getMesorregiao(), util));
                // mapeamento.setControle(localReferente(mapeamento.getMesorregiao(), util).getNome());
            } else if (mapeamento.getEstado() != null) {
                mapeamento.setMunicipio(localReferente(mapeamento.getEstado(), util));
                // mapeamento.setControle(localReferente(mapeamento.getEstado(), util).getNome());
            } else if (mapeamento.getRegiao() != null) {
                mapeamento.setMunicipio(localReferente(mapeamento.getRegiao(), util));
                //mapeamento.setControle(localReferente(mapeamento.getRegiao(), util).getNome());
            } else {
                mapeamento.setMunicipio(util.get(0));
                //mapeamento.setControle(util.get(0).getNome());
            }
            System.out.println("Municipio: "+mapeamento.getMunicipio());
        }
        return mapeamento;
    }

    private static Local retiraRegiao(List<Local> locais) {
        Local regiao = null;
        for (Local local : locais) {
            if (local.getTipo().equalsIgnoreCase("regiao")) {
                regiao = local;
            }
        }
        return regiao;
    }

    private static List<Local> retiraEstados(List<Local> locais) {
        List<Local> estados = new ArrayList<>();
        for (Local local : locais) {
            if (local.getTipo().equalsIgnoreCase("estado")) {
                estados.add(local);
            }
        }
        return estados;
    }

    private static List<Local> retiraMesorregioes(List<Local> locais) {
        List<Local> mesos = new ArrayList<>();
        for (Local local : locais) {
            if (local.getTipo().equalsIgnoreCase("mesorregiao")) {
                mesos.add(local);
            }
        }
        return mesos;
    }

    private static List<Local> retiraMicrorregioes(List<Local> locais) {
        List<Local> micros = new ArrayList<>();
        for (Local local : locais) {
            if (local.getTipo().equalsIgnoreCase("microrregiao")) {
                micros.add(local);
            }
        }
        return micros;
    }

    private static List<Local> retiraMunicipios(List<Local> locais) {
        List<Local> municipios = new ArrayList<>();
        for (Local local : locais) {
            if (local.getTipo().equalsIgnoreCase("municipio")) {
                municipios.add(local);
            }
        }
        return municipios;
    }

    private static Local localReferente(Local geoMaior, List<Local> locais) {
        Local result = null;

        for (Local local : locais) {
            if (GazetteerDao.contem(geoMaior, local)) {
                result = local;
            }
        }

        return result;
    }
}
