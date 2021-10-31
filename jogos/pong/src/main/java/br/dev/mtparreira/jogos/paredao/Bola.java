package br.dev.mtparreira.jogos.paredao;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

public class Bola {
	
	private Cor cor;
	private Boolean sentidoX, sentidoY;
	private Float tamanho, deslocamentoX, deslocamentoY, velocidade, y1, y2;

	public Bola(Cor cor) {		
		this.cor = cor;
		this.tamanho    = 0.025f;
		this.velocidade = 0.003f;
		this.deslocamentoX  = 0f;
		this.deslocamentoY  = 0f;
		this.sentidoX = new Random().nextBoolean();
		this.sentidoY = new Random().nextBoolean();
	}
	
	public void desenhar() {
		glBegin(GL_QUADS);
			glColor4f(cor.getVermelho(), cor.getVerde(), cor.getAzul(), cor.getAlfa());
			glVertex2f(( tamanho + deslocamentoX), ( tamanho + deslocamentoY)); // +x +y
			glVertex2f((-tamanho + deslocamentoX), ( tamanho + deslocamentoY)); // -x +y			
			glVertex2f((-tamanho + deslocamentoX), (-tamanho + deslocamentoY)); // -x -y
			glVertex2f(( tamanho + deslocamentoX), (-tamanho + deslocamentoY)); // +x -y
		glEnd();
		y1 = ( tamanho + deslocamentoY);
		y2 = (-tamanho + deslocamentoY);
	}
	
	private void paraCima() {
		if (deslocamentoY <= (1-tamanho)) {
			deslocamentoY += velocidade;
		} else {
			sentidoY = false;
			paraBaixo();
		}
	}
	
	private void paraBaixo() {
		if (deslocamentoY >= (tamanho-1)) {
			deslocamentoY -= velocidade;
		} else {
			sentidoY = true;
			paraCima();
		}
	}
	
	private void paraDireita() {
		if (deslocamentoX <= (1-tamanho)) {
			deslocamentoX += velocidade;
		} else {
			sentidoX = false;
			paraEsquerda();
		}
	}
	
	private void paraEsquerda() {
		if (deslocamentoX >= (tamanho-1)) {
			deslocamentoX -= velocidade;
		} else {
			sentidoX = true;
			paraDireita();
		}
	}
	
	public void mover() {		
		if (sentidoX) {
			paraDireita();
		} else {
			paraEsquerda();
		}		
		if (sentidoY) {
			paraCima();
		} else {
			paraBaixo();
		}		
	}
	
	public void inverterSentidoX() {
		sentidoX = !sentidoX;
	}
	
	public void inverterSentidoY() {
		sentidoY = !sentidoY;
	}
	
	public void adicionarVelocidade() {
		if (velocidade < 0.010f) velocidade += 0.001f;
	}
	
	public void retirarVelocidade() {
		if (velocidade > 0.005f) velocidade -= 0.001f;
	}

	public Boolean houveColisaoCima(Float espessura) {
		return !((1-espessura)>( tamanho+deslocamentoY));
	}

	public Boolean houveColisaoBaixo(Float espessura) {
		return !((espessura-1)<(-tamanho+deslocamentoY));
	}

	public Boolean houveColisaoDireita(Float espessura) {
		return !((1-espessura)>( tamanho+deslocamentoX));
	}

	public Boolean houveColisaoEsquerda(Float espessura) {
		return !((espessura-1)<(-tamanho+deslocamentoX));
	}

	public Boolean houveColisaoJogador(Float espessura, Float y1, Float y2) {
		return houveColisaoEsquerda(espessura) && ((this.y1 >= y2) && (this.y2 <= y1));
	}
			
}
