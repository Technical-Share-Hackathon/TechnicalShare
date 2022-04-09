import { AreasDeInteresse } from "./areas-de-interesse";
import { Experiencia } from "./experiencia";
import { HardSkills } from "./hard-skills";
import { LinksDisponiveis } from "./links-disponiveis";
import { SoftSkills } from "./soft-skills";

export class UsuarioCompleto {

  public id! : number;

  public nome!: string;

  public linkFoto!: string;

  public profissaoAtual! : string;

  public squad! : string;

  public nivelSenioridade! : string;

  public resumo!: string;

  public email! : string;


  public linksDisponiveis! : LinksDisponiveis;

  public softSkills! : SoftSkills;

  public hardSkills! : HardSkills;

  public areaDeInteresse! : AreasDeInteresse;

  public experiencias! : Experiencia[]
}
