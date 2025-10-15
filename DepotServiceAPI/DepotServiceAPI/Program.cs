using DepotServiceAPI.Data;
using DepotServiceAPI.Repositories;
using DepotServiceAPI.Services;
using Microsoft.EntityFrameworkCore; 

var builder = WebApplication.CreateBuilder(args);

// 🔹 Ajout du DbContext PostgreSQL
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseNpgsql(builder.Configuration.GetConnectionString("DefaultConnection")));

// 🔹 Enregistrement du Repository et du Service pour l'injection de dépendances
builder.Services.AddScoped<TauxRepository>();
builder.Services.AddScoped<TauxService>();
builder.Services.AddScoped<CompteDepotRepository>();
builder.Services.AddScoped<CompteDepotService>();
builder.Services.AddScoped<TypeOperationRepository>();
builder.Services.AddScoped<TypeOperationService>();
builder.Services.AddScoped<StatusRepository>();
builder.Services.AddScoped<StatusService>();
builder.Services.AddScoped<OperationsDepotRepository>();
builder.Services.AddScoped<OperationsDepotService>();
builder.Services.AddScoped<HistoriqueStatusRepository>();
builder.Services.AddScoped<HistoriqueStatusService>();

// Services par défaut
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
