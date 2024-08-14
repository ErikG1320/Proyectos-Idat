using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;

using Microsoft.OpenApi.Models;
using NeptunoWebApi21.Models;
using Microsoft.EntityFrameworkCore;

namespace NeptunoWebApi21
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        private void AddSwagger(IServiceCollection services)
        {
            services.AddSwaggerGen(options =>
            {
                var groupName = "v1";

                options.SwaggerDoc(groupName, new OpenApiInfo
                {
                    Title = $"Neptuno API {groupName}",
                    Version = groupName,
                    Description = "Neptuno API",
                    Contact = new OpenApiContact
                    {
                        Name = "Neptuno Company",
                        Email = string.Empty,
                        Url = new Uri("https://foo.com/"),
                    }
                });
            });
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);

            AddSwagger(services);

            //
            // recuperamos la cadena de conexion de appsettings.json
            string cadena = Configuration.GetConnectionString("cn1");

            // establecemos la cadena de conexion recuperada para que lo utilice
            // el EntityFramework Core
            services.AddDbContext<Neptuno2023Context>(
                           opt => opt.UseSqlServer(cadena));

            //
            services.AddCors();

        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            //escribiremos:
            // Permitir que React acceda al servicio web api por medio de:
            // http://localhost:3000

            app.UseCors(
                opt =>
                {
                    opt.AllowAnyHeader();
                    opt.AllowAnyMethod();
                    opt.AllowAnyOrigin();
                    //opt.WithOrigins("http://localhost:3000");
                });

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseMvc();

            //
            app.UseSwagger();
            app.UseSwaggerUI(c =>
            {
                c.SwaggerEndpoint("/swagger/v1/swagger.json", "Neptuno API V1");
            });
        }
    }
}
