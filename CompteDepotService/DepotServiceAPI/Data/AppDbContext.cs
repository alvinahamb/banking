using Microsoft.EntityFrameworkCore;
using DepotServiceAPI.Models;

namespace DepotServiceAPI.Data
{
    public class AppDbContext(DbContextOptions<AppDbContext> options) : DbContext(options)
    {
        public DbSet<Taux> Taux { get; set; }
        public DbSet<CompteDepot> CompteDepot { get; set; }
        public DbSet<HistoriqueStatusComptes> HistoriqueStatusComptes { get; set; }
        public DbSet<OperationsDepot> OperationsDepot { get; set; }
        public DbSet<Status> Status { get; set; }
        public DbSet<TypeOperation> TypeOperation { get; set; }


        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Taux>(entity =>
            {
                entity.ToTable("taux");
                entity.HasKey(e => e.IdTaux)
                      .HasName("pk_taux");
                entity.Property(e => e.IdTaux)
                      .UseIdentityAlwaysColumn();
            });

            modelBuilder.Entity<CompteDepot>(entity =>
            {
                entity.ToTable("compteDepot");
                entity.HasKey(e => e.IdCompteDepot)
                      .HasName("pk_compteDepot");
                entity.Property(e => e.IdCompteDepot)
                      .UseIdentityAlwaysColumn();
            });

            modelBuilder.Entity<HistoriqueStatusComptes>(entity =>
            {
                entity.ToTable("historiqueStatusComptes");
                entity.HasKey(e => e.IdHistoriqueDepot)
                      .HasName("pk_historiqueStatusComptes");
                entity.Property(e => e.IdHistoriqueDepot)
                      .UseIdentityAlwaysColumn();
            });

            modelBuilder.Entity<OperationsDepot>(entity =>
            {
                entity.ToTable("operationsDepot");
                entity.HasKey(e => e.IdOperation)
                      .HasName("pk_operationsDepot");
                entity.Property(e => e.IdOperation)
                      .UseIdentityAlwaysColumn();
            });

            modelBuilder.Entity<Status>(entity =>
            {
                entity.ToTable("status");
                entity.HasKey(e => e.IdStatus)
                      .HasName("pk_status");
                entity.Property(e => e.IdStatus)
                      .UseIdentityAlwaysColumn();
            });

            modelBuilder.Entity<TypeOperation>(entity =>
            {
                entity.ToTable("typeOperation");
                entity.HasKey(e => e.IdTypeOperation)
                      .HasName("pk_typeOperation");
                entity.Property(e => e.IdTypeOperation)
                      .UseIdentityAlwaysColumn();
            });
        }
    }
}
