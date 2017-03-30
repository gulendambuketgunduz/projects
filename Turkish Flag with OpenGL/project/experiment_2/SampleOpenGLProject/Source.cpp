#include "angel.h"
#include "glew.h"
#include "freeglut.h"
#include <iostream>
#include <string>
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

static const GLfloat r = 0.125;
static const GLfloat cos18 = 0.9510565163;
static const GLfloat sin72 = 0.9510565163;
static const GLfloat sin18 = 0.3090169944;
static const GLfloat sin126 = 0.8090169944;
static const GLfloat cos36 = 0.8090169944;
static const GLfloat sin54 = 0.8090169944;
static const GLfloat sin36 = 0.5877852523;
static const GLfloat a = (sin18 / sin126)*r; /*It is coming from sinus teorem*/

GLuint LoadShaders(const char *vertex_file, const char *frag_file) {

	GLuint vertShader = glCreateShader(GL_VERTEX_SHADER);
	GLuint fragShader = glCreateShader(GL_FRAGMENT_SHADER);

	std::string vertShaderStr;
	std::ifstream vertexStream(vertex_file, std::ios::in);
	std::string line = "";

	while (!vertexStream.eof()) {
		std::getline(vertexStream, line);
		vertShaderStr.append(line + "\n");
	}
	vertexStream.close();
	const char *vertShaderSrc = vertShaderStr.c_str();

	std::string fragShaderStr;
	std::ifstream fragStream(frag_file, std::ios::in);

	line = "";
	while (!fragStream.eof()) {
		std::getline(fragStream, line);
		fragShaderStr.append(line + "\n");
	}
	fragStream.close();
	const char *fragShaderSrc = fragShaderStr.c_str();

	glShaderSource(vertShader, 1, &vertShaderSrc, NULL);
	glCompileShader(vertShader);

	GLint  compiled;
	glGetShaderiv(vertShader, GL_COMPILE_STATUS, &compiled);
	if (!compiled) {
		std::cerr << vertShaderStr << " failed to compile:" << std::endl;
		GLint  logSize;
		glGetShaderiv(vertShader, GL_INFO_LOG_LENGTH, &logSize);
		char* logMsg = new char[logSize];
		glGetShaderInfoLog(vertShader, logSize, NULL, logMsg);
		std::cerr << logMsg << std::endl;
		delete[] logMsg;

		exit(EXIT_FAILURE);
	}

	glShaderSource(fragShader, 1, &fragShaderSrc, NULL);
	glCompileShader(fragShader);

	GLuint myshader = glCreateProgram();
	glAttachShader(myshader, vertShader);
	glAttachShader(myshader, fragShader);
	glLinkProgram(myshader);

	glDeleteShader(vertShader);
	glDeleteShader(fragShader);

	return myshader;
}

void display(void)
{
	mat4 translateMatrix{
		vec4(1,0,0,0),
		vec4(0,1,0,0),
		vec4(0,0,1,0),
		vec4(0,0,0,1),
	};
	mat4 rotateMatrix{
		vec4(cos(-36),sin(-36),0,0),
		vec4(-sin(-36),cos(-36),0,0),
		vec4(0,0,1,0),
		vec4(0.2,0,0,1),
	};
	//First triangles's coordinates
	vec2 vertices[] = {
		vec2(-r*cos18, r*sin18),
		vec2(r*cos18, r*sin18),
		vec2(0.0, -a)
	};
	//Second triangles's coordinates
	vec2 vertices2[] = {
		vec2(-r*sin36, -r*cos36),
		vec2(a*sin36 + 2 * a*sin36*sin18, r*sin18 - 2 * a*sin36*sin72),
		vec2(0.0, r)
	};
	//Third triangles's coordinates
	vec2 vertices3[] = {
		vec2(r*sin36, -r*cos36),
		vec2(-(a*sin36 + 2 * a*sin36*sin18), r*sin18 - 2 * a*sin36*sin72),
		vec2(0.0, r)
	};
	//for the rectangular
	vec2 vertices4[] = {
		vec2(-0.75, -0.5),
		vec2(-0.75, 0.5),
		vec2(0.75, 0.5),
		vec2(0.75, -0.5)
	};
	
	glClearColor(0.0, 1.0, 1.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT);

	GLuint vao;
	glGenVertexArrays(1, &vao);
	glBindVertexArray(vao);
	
	// Create and initialize a buffer object
	GLuint buffer;
	glGenBuffers(1, &buffer);
	glBindBuffer(GL_ARRAY_BUFFER, buffer);

	GLuint rectangular = LoadShaders("vshader.glsl", "fshader.glsl");
	glUseProgram(rectangular);

	GLint vPosition = glGetAttribLocation(rectangular, "vPosition");
	glVertexAttribPointer((GLuint)0, 2, GL_FLOAT, GL_FALSE, 0, 0);
	glEnableVertexAttribArray(0);

	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices4), vertices4,
		GL_STATIC_DRAW);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 4);

	GLfloat x, y;
	GLfloat bigCir[724];
	GLfloat smallCir[724];
	bigCir[0] = -0.16;
	bigCir[1] = 0.0;
	smallCir[0] = -0.1;
	smallCir[1] = 0.0;

	for (int i = 1; i<=361; i++)
	{
		x = 0.25*cos((i%360)*2.0f*3.14f / 360);
		y = 0.25*sin((i%360)*2.0f*3.14f / 360);

		bigCir[2 * i] = x-0.16;
		bigCir[(2 * i) + 1] = y;

		smallCir[2 * i] = (x*0.8)-0.1;
		smallCir[(2 * i) + 1] = y*0.8;
	}

	GLuint big = LoadShaders("vshader_bCircle.glsl", "fshader_bCircle.glsl");
	glUseProgram(big);

	glBindBuffer(GL_ARRAY_BUFFER, vao);
	glBufferData(GL_ARRAY_BUFFER, 724 * sizeof(GLfloat), bigCir, GL_STATIC_DRAW);
	glVertexAttribPointer((GLuint)0, 2, GL_FLOAT, GL_FALSE, 0, 0);
	glEnableVertexAttribArray(0);
	glBindVertexArray(0);
	
	
	glEnableClientState(GL_VERTEX_ARRAY);
	glBindVertexArray(vao);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 362);
	glDisableClientState(GL_VERTEX_ARRAY);

	GLuint small = LoadShaders("vshader_sCircle.glsl", "fshader_sCircle.glsl");
	glUseProgram(small);

	glBindBuffer(GL_ARRAY_BUFFER, vao);
	glBufferData(GL_ARRAY_BUFFER, 724 * sizeof(GLfloat), smallCir, GL_STATIC_DRAW);
	glVertexAttribPointer((GLuint)0, 2, GL_FLOAT, GL_FALSE, 0, 0);
	glEnableVertexAttribArray(0);
	glBindVertexArray(0);

	glEnableClientState(GL_VERTEX_ARRAY);
	glBindVertexArray(vao);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 362);
	glDisableClientState(GL_VERTEX_ARRAY);
	
	GLuint star = LoadShaders("vshader_star.glsl", "fshader_star.glsl");
	glUseProgram(star);

	GLint vPosition_star = glGetAttribLocation(star, "vPosition2");


	GLint uniTrans = glGetUniformLocation(star, "trans");
	glUniformMatrix4fv(uniTrans, 1, GL_FALSE, translateMatrix);

	GLint uniRotate = glGetUniformLocation(star, "rotate");
	glUniformMatrix4fv(uniRotate, 1, GL_FALSE, rotateMatrix);


	glVertexAttribPointer((GLuint)0, 2, GL_FLOAT, GL_FALSE, 0, 0);
	glEnableVertexAttribArray(0);

	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices,
		GL_STATIC_DRAW);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 3);

	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices2), vertices2,
		GL_STATIC_DRAW);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 3);

	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices3), vertices3,
		GL_STATIC_DRAW);
	glDrawArrays(GL_TRIANGLE_FAN, 0, 3);

	glFlush();
}

void keyboard(unsigned char key, int x, int y)
{
	switch (key) {
	case 27:
		exit(EXIT_SUCCESS);
		break;
	}
}

int main(int argc, char **argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DEPTH | GLUT_SINGLE | GLUT_RGBA);
	glutInitWindowSize(512, 512);
	glutInitWindowPosition(800, 0);

	glutInitContextVersion(3, 1);
	glutInitContextFlags(GLUT_FORWARD_COMPATIBLE);
	glutInitContextProfile(GLUT_CORE_PROFILE);

	glutCreateWindow("My Window");
	glewExperimental = TRUE;
	glewInit();
	
	glutDisplayFunc(display);
	glutKeyboardFunc(keyboard);

	glutMainLoop();
	return 0;
}