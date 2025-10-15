using System;
using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace DepotServiceAPI.Migrations
{
    /// <inheritdoc />
    public partial class initiate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "status",
                columns: table => new
                {
                    IdStatus = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    Libelle = table.Column<string>(type: "text", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_status", x => x.IdStatus);
                });

            migrationBuilder.CreateTable(
                name: "taux",
                columns: table => new
                {
                    IdTaux = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    Valeur = table.Column<double>(type: "double precision", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_taux", x => x.IdTaux);
                });

            migrationBuilder.CreateTable(
                name: "typeOperation",
                columns: table => new
                {
                    IdTypeOperation = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    Libelle = table.Column<string>(type: "text", nullable: false),
                    Credit = table.Column<bool>(type: "boolean", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_typeOperation", x => x.IdTypeOperation);
                });

            migrationBuilder.CreateTable(
                name: "compteDepot",
                columns: table => new
                {
                    IdCompteDepot = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    NumeroCompte = table.Column<string>(type: "text", nullable: false),
                    IdClient = table.Column<int>(type: "integer", nullable: false),
                    SoldeActuel = table.Column<double>(type: "double precision", nullable: false),
                    DateOuverture = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    DateCloture = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    IdTaux = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_compteDepot", x => x.IdCompteDepot);
                    table.ForeignKey(
                        name: "FK_compteDepot_taux_IdTaux",
                        column: x => x.IdTaux,
                        principalTable: "taux",
                        principalColumn: "IdTaux",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "historiqueStatusComptes",
                columns: table => new
                {
                    IdHistoriqueDepot = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    IdCompteDepot = table.Column<int>(type: "integer", nullable: false),
                    IdStatus = table.Column<int>(type: "integer", nullable: false),
                    DateChangement = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_historiqueStatusComptes", x => x.IdHistoriqueDepot);
                    table.ForeignKey(
                        name: "FK_historiqueStatusComptes_compteDepot_IdCompteDepot",
                        column: x => x.IdCompteDepot,
                        principalTable: "compteDepot",
                        principalColumn: "IdCompteDepot",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_historiqueStatusComptes_status_IdStatus",
                        column: x => x.IdStatus,
                        principalTable: "status",
                        principalColumn: "IdStatus",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "operationsDepot",
                columns: table => new
                {
                    IdOperation = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityAlwaysColumn),
                    Montant = table.Column<double>(type: "double precision", nullable: false),
                    DateOperation = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    DateValeur = table.Column<DateTime>(type: "timestamp with time zone", nullable: false),
                    SoldeActuel = table.Column<double>(type: "double precision", nullable: false),
                    IdVirement = table.Column<int>(type: "integer", nullable: true),
                    IdTypeTransaction = table.Column<int>(type: "integer", nullable: false),
                    IdCompteDepot = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("pk_operationsDepot", x => x.IdOperation);
                    table.ForeignKey(
                        name: "FK_operationsDepot_compteDepot_IdCompteDepot",
                        column: x => x.IdCompteDepot,
                        principalTable: "compteDepot",
                        principalColumn: "IdCompteDepot",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_operationsDepot_typeOperation_IdTypeTransaction",
                        column: x => x.IdTypeTransaction,
                        principalTable: "typeOperation",
                        principalColumn: "IdTypeOperation",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_compteDepot_IdTaux",
                table: "compteDepot",
                column: "IdTaux");

            migrationBuilder.CreateIndex(
                name: "IX_historiqueStatusComptes_IdCompteDepot",
                table: "historiqueStatusComptes",
                column: "IdCompteDepot");

            migrationBuilder.CreateIndex(
                name: "IX_historiqueStatusComptes_IdStatus",
                table: "historiqueStatusComptes",
                column: "IdStatus");

            migrationBuilder.CreateIndex(
                name: "IX_operationsDepot_IdCompteDepot",
                table: "operationsDepot",
                column: "IdCompteDepot");

            migrationBuilder.CreateIndex(
                name: "IX_operationsDepot_IdTypeTransaction",
                table: "operationsDepot",
                column: "IdTypeTransaction");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "historiqueStatusComptes");

            migrationBuilder.DropTable(
                name: "operationsDepot");

            migrationBuilder.DropTable(
                name: "status");

            migrationBuilder.DropTable(
                name: "compteDepot");

            migrationBuilder.DropTable(
                name: "typeOperation");

            migrationBuilder.DropTable(
                name: "taux");
        }
    }
}
