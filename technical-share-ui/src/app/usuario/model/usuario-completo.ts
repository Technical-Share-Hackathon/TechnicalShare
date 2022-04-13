import { SoftSkills } from "./soft-skills"
import { LinksDisponiveis } from "./links-disponiveis"
import { HardSkills } from "./hard-skills"
import { Experiencias } from "./experiencias"
import { AreaDeInteresse } from "./area-de-interesse"


export class UsuarioCompleto {

    email!: string
    id!: number
    linkFoto!: string
    nivelSenioridade!: string
    nome!: string
    profissaoAtual!: string
    resumo!: string
    squad!: string
    softSkills!: SoftSkills
    linksDisponiveis!: LinksDisponiveis
    hardSkills!: HardSkills
    experiencias!: Experiencias[]
    areaDeInteresse!: AreaDeInteresse
}
