#version 430
in vec2 vPosition2;

uniform mat4 trans;
uniform mat4 rotate;

void main()
{
	    gl_Position = rotate * trans * vec4(vPosition2, 0.0, 1.0);

}