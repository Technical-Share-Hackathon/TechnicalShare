import { AreasDeInteresse } from "./areas-de-interesse";
import { HardSkills } from "./hard-skills";
import { LinksDisponiveis } from "./links-disponiveis";
import { SoftSkills } from "./soft-skills";

export class UsuarioCompleto {

  public id! : number;

  public nome!: string;

  public linkFoto!: string;

  public profissaoAtual! : string;

  public resumo!: string;

  public email! : string;

  public senha! : string;

  public linksDisponiveis! : LinksDisponiveis;

  public softSkills! : SoftSkills;

  public hardSkills! : HardSkills;

  public areaDeInteresse! : AreasDeInteresse;
}
