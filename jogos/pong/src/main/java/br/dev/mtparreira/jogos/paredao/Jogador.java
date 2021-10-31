package br.dev.mtparreira.jogos.paredao;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Jogador {
	
	private Cor cor;
	private Float tamanho, espessura, deslocamentoY, y1, y2;		
	
	public Jogador(Cor cor) {		
		this.cor = cor;
		this.tamanho = 0.100f;
		this.espessura = 0.050f;		
		this.deslocamentoY = 0f;
	}
	
	public void desenhar() {
		glBegin(GL_QUADS);
			glColor4f(cor.getVermelho(), cor.getVerde(), cor.getAzul(), cor.getAlfa());
			glVertex2f(-1f          , tamanho+deslocamentoY);
			glVertex2f(-1f+espessura, tamanho+deslocamentoY); 
			glVertex2f(-1f+espessura,-tamanho+deslocamentoY);
			glVertex2f(-1f          ,-tamanho+deslocamentoY);
		glEnd();
		y1 =  tamanho+deslocamentoY;
		y2 = -tamanho+deslocamentoY;
	}

	public Float getY1() {
		return y1;
	}

	public Float getY2() {
		return y2;
	}
	
	public Float getEspessura() {
		return this.espessura;
	}
	
	public void paraCima() {
		if (deslocamentoY <= (1-tamanho)) deslocamentoY += 0.007f;
	}
	
	public void paraBaixo() {
		if (deslocamentoY >= (tamanho-1)) deslocamentoY -= 0.007f;
	}

	public Boolean houveColisaoCima(Float espessura) {
		return !((1-espessura)>( tamanho+deslocamentoY));			
	}
	
	public Boolean houveColisaoBaixo(Float espessura) {
		return !((espessura-1)<(-tamanho+deslocamentoY));
	}
			
}
