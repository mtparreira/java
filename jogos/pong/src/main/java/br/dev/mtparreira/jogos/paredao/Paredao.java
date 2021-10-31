package br.dev.mtparreira.jogos.paredao;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.GLFW_DOUBLEBUFFER;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F10;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F11;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F12;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

public class Paredao {

	private long janela;
	private Bola bola = new Bola(Cor.MAGENTA);
	private Jogador jogador = new Jogador(Cor.AZUL);
	
	private Lateral cima     = new Lateral(0.050f, Posicao.CIMA,     Cor.BRANCA);
	private Lateral baixo    = new Lateral(0.050f, Posicao.BAIXO,    Cor.BRANCA);
	private Lateral direita  = new Lateral(0.035f, Posicao.DIREITA,  Cor.BRANCA);
	private Lateral esquerda = new Lateral(0.035f, Posicao.ESQUERDA, Cor.PRETA );
	
	public void run() {
		System.out.println("Paredão " + Version.getVersion() + "!");
		System.out.println("Comandos:");
		System.out.println("    F10 -> iniciar/continuar");
		System.out.println("    F11 -> pausar");
		System.out.println("    F12 -> reiniciar");
		System.out.println("  <ESC> -> sair");
		
		init();
		loop();

		glfwFreeCallbacks(janela);
		glfwDestroyWindow(janela);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
	
	
	public void init() {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Não foi possível inicializar GLFW");

		glfwDefaultWindowHints();		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_FALSE);

		janela = glfwCreateWindow(800, 600, "Paredão", NULL, NULL);
		if (janela == NULL)
			throw new RuntimeException("Falha ao criar uma janela GLFW");

		glfwSetKeyCallback(janela, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true);
		});

		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);
			glfwGetWindowSize(janela, pWidth, pHeight);
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			glfwSetWindowPos(janela, ((vidmode.width() - pWidth.get(0)) / 2), ((vidmode.height() - pHeight.get(0)) / 2));
		}

		glfwMakeContextCurrent(janela);
		glfwSwapInterval(1);
		glfwShowWindow(janela);
	}
	
	private void loop() {
		Boolean ponto = false;
		Boolean jogando = false;
		Boolean acelerador = false;
		GL.createCapabilities();
		glClearColor(Cor.PRETA.getVermelho(), Cor.PRETA.getVerde(), Cor.PRETA.getAzul(), Cor.PRETA.getAlfa());

		while (!glfwWindowShouldClose(janela)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glfwPollEvents();
			
			if (glfwGetKey(janela, GLFW_KEY_ESCAPE) == GLFW_TRUE) break;		// encerrar
			if (glfwGetKey(janela, GLFW_KEY_F10) == GLFW_TRUE) jogando = true; 	// iniciar / continuar
			if (glfwGetKey(janela, GLFW_KEY_F11) == GLFW_TRUE) jogando = false; // pausar
			if (glfwGetKey(janela, GLFW_KEY_F12) == GLFW_TRUE) {				// reiniciar
				ponto = false;
				jogando = false;
				bola = new Bola(Cor.MAGENTA);
				jogador = new Jogador(Cor.AZUL);
				esquerda = new Lateral(0.035f, Posicao.ESQUERDA, Cor.PRETA );
			}
			
			esquerda.desenhar();
			direita.desenhar();
			baixo.desenhar();
			cima.desenhar();
			
			if (jogando) { // bola e jogador em movimento
				
				acelerador = false;
				if ((glfwGetKey(janela, GLFW_KEY_UP) == GLFW_TRUE) && (!jogador.houveColisaoCima(cima.getEspessura()))) {
					jogador.paraCima();
					acelerador = true;
				}
				if ((glfwGetKey(janela, GLFW_KEY_DOWN) == GLFW_TRUE) && (!jogador.houveColisaoBaixo(baixo.getEspessura()))) {
					jogador.paraBaixo();
					acelerador = true;
				}
				
				if (bola.houveColisaoCima    (cima.getEspessura()))    bola.inverterSentidoY();
				if (bola.houveColisaoBaixo   (baixo.getEspessura()))   bola.inverterSentidoY();
				if (bola.houveColisaoDireita (direita.getEspessura())) bola.inverterSentidoX();
				if (bola.houveColisaoJogador (jogador.getEspessura(), jogador.getY1(), jogador.getY2())) {
					bola.inverterSentidoX();
					bola.inverterSentidoY();
					if (acelerador) {
						bola.adicionarVelocidade();
					} else {
						bola.retirarVelocidade();
					}
				}
				
				bola.mover();
				if (bola.houveColisaoEsquerda(esquerda.getEspessura())) {
					ponto = true;
					jogando = false;						
				}
												
			}			
			
			bola.desenhar();
			jogador.desenhar();
			if (ponto) esquerda.alternarCor();
			
			glfwSwapBuffers(janela);						
		}
		
	}
	

	public static void main(String[] args) {
		new Paredao().run();
	}

}
