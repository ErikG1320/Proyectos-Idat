using Microsoft.EntityFrameworkCore;
using NeptunoWebApi.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

// recuperando la cadena de conexión desde el appsettings.json
var cadena = builder.Configuration.GetConnectionString("cn1");

// registrando el contexto del EF Core en la aplicación y que utilice
// la cadena de conexión
builder.Services.AddDbContext<Neptuno2023Context>(
    opt=>opt.UseSqlServer(cadena));

// para permitir que aplicaciones de otros dominios puedan
// interactuar con el proyecto
builder.Services.AddCors();


builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();


// Permitir que React acceda al servicio web api por medio de:
// http://localhost:3000
app.UseCors(
    opt =>
    {
        opt.AllowAnyHeader();
        opt.AllowAnyMethod();
        //opt.AllowAnyOrigin();
        opt.WithOrigins("http://localhost:3000");
    });


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
