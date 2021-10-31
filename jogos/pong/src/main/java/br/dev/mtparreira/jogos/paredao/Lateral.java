package br.dev.mtparreira.jogos.paredao;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

public class Lateral {

	private Cor cor;
	private Posicao posicao;
	private Float espessura;
	
	public Lateral(Float espessura, Posicao posicao, Cor cor ) {		
		this.espessura = espessura;
		this.posicao = posicao;
		this.cor = cor;
	}
	
	public void desenhar() {
		glBegin(GL_QUADS);
			glColor4f(cor.getVermelho(), cor.getVerde(), cor.getAzul(), cor.getAlfa());
			switch (posicao) {
				case CIMA:
					glVertex2f(-1f, 1f          ); 
					glVertex2f( 1f, 1f          );
					glVertex2f( 1f, 1f-espessura);
					glVertex2f(-1f, 1f-espessura);
					break;
				case BAIXO:
					glVertex2f(-1f,-1f+espessura); 
					glVertex2f( 1f,-1f+espessura);
					glVertex2f( 1f,-1f          );
					glVertex2f(-1f,-1f          );
					break;
				case DIREITA:
					glVertex2f( 1f-espessura, 1f); 
					glVertex2f( 1f,           1f);
					glVertex2f( 1f,          -1f);
					glVertex2f( 1f-espessura,-1f);
					break;
				case ESQUERDA:
					glVertex2f(-1f,           1f); 
					glVertex2f(-1f+espessura, 1f);
					glVertex2f(-1f+espessura,-1f);
					glVertex2f(-1f,          -1f);
					break;
				default:
					break;
			}
		glEnd();
	}
	
	public Float getEspessura() {
		return this.espessura;
	}

	public void alternarCor() {
		Integer random = new Random().nextInt(4);
		switch(random) {
			case 1:
				cor = Cor.AZUL;
				break;
			case 2:
				cor = Cor.BRANCA;
				break;
			case 3:
				cor = Cor.MAGENTA;
				break;
			default:
				cor = Cor.PRETA;			
		}
	}
				
}
