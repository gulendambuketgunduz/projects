#include "angel.h"
static const GLfloat r = 0.75;
static const GLfloat cos18 = 0.9510565163;
static const GLfloat sin72 = 0.9510565163;
static const GLfloat sin18 = 0.3090169944;
static const GLfloat sin126 = 0.8090169944;
static const GLfloat cos36 = 0.8090169944;
static const GLfloat sin54 = 0.8090169944;
static const GLfloat sin36 = 0.5877852523;
static const GLfloat a = (sin18 / sin126)*r; /*It is coming from sinus teorem*/
											 /*First triangles's coordinates*/
static const vec2 vertices[] = {
	vec2(-r*cos18, r*sin18),
	vec2(r*cos18, r*sin18),
	vec2(0.0, -a)
};
/*Second triangles's coordinates*/
static const vec2 vertices2[] = {
	vec2(-r*sin36, -r*cos36),
	vec2(a*sin36 + 2 * a*sin36*sin18, r*sin18 - 2 * a*sin36*sin72),
	vec2(0.0, r)
};
/*Third triangles's coordinates*/
static const vec2 vertices3[] = {
	vec2(r*sin36, -r*cos36),
	vec2(-(a*sin36 + 2 * a*sin36*sin18), r*sin18 - 2 * a*sin36*sin72),
	vec2(0.0, r)
};

/*It display triangles*/
void display(void)
{

	glClear(GL_COLOR_BUFFER_BIT);
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

void init()
{ // Create a vertex array object
	GLuint vao;
	glGenVertexArrays(1, &vao);
	glBindVertexArray(vao);
	// Create and initialize a buffer object
	GLuint buffer;
	glGenBuffers(1, &buffer);
	glBindBuffer(GL_ARRAY_BUFFER, buffer);
	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices,
		GL_STATIC_DRAW);
	// Load shaders and use the resulting shader program
	GLuint program = InitShader("vshader.glsl", "fshader.glsl");
	glUseProgram(program);
	// set up vertex arrays
	GLuint vPosition = glGetAttribLocation(program, "vPosition");
	glEnableVertexAttribArray(vPosition);
	glVertexAttribPointer(vPosition, 2, GL_FLOAT, GL_FALSE, 0, 0);
	// Paint the background black
	glClearColor(1.0, 0.0, 0.0, 1.0);
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
	glewInit();
	init();

	glutDisplayFunc(display);
	glutKeyboardFunc(keyboard);

	glutMainLoop();
	return 0;
}